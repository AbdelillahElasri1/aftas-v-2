package ma.youcode.aftasclubapiv2.services.implementations;

import lombok.RequiredArgsConstructor;
import ma.youcode.aftasclubapiv2.dto.requests.HuntRequest;
import ma.youcode.aftasclubapiv2.dto.responses.HuntResponse;
import ma.youcode.aftasclubapiv2.entities.*;
import ma.youcode.aftasclubapiv2.entities.embedded.RankId;
import ma.youcode.aftasclubapiv2.exceptions.ResourceNotFoundException;
import ma.youcode.aftasclubapiv2.exceptions.UnsupportedActionException;
import ma.youcode.aftasclubapiv2.mapper.HuntingMapper;
import ma.youcode.aftasclubapiv2.repositories.*;
import ma.youcode.aftasclubapiv2.services.HuntingService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class HuntingServiceImpl extends AbstractServiceImpl<UUID, HuntRequest, HuntResponse, Hunting, HuntingRepository, HuntingMapper> implements HuntingService
{
    private final UserRepository userRepository;
    private final CompetitionRepository competitionRepository;
    private final FishRepository fishRepository;
    private final RankingRepository rankingRepository;
    private final HuntingRepository huntingRepository;
    private final HuntingMapper mapper;
    @Override
    public Optional<HuntResponse> create(HuntRequest huntingRequest) {
        User member = userRepository.findByEmail(huntingRequest.user().email())
                .orElseThrow(() -> new ResourceNotFoundException("Member not Found with Email: " + huntingRequest.user().email()));
        Competition competition = competitionRepository.getCompetitionByDate(huntingRequest.competition().date())
                .orElseThrow(() -> new ResourceNotFoundException("Competition not Found with Date: " + huntingRequest.competition().date()));
        Fish fish = fishRepository.findByName(huntingRequest.fish().name())
                .orElseThrow(() -> new ResourceNotFoundException("Fish not Found with Name: " + huntingRequest.fish().name()));

        if (LocalDate.now().isBefore(competition.getDate()) || LocalTime.now().isBefore(competition.getStartTime())) {
            throw new UnsupportedActionException("Cannot add hunts, competition didn't start yet");
        }

        if (LocalDate.now().isAfter(competition.getDate()) || LocalTime.now().isAfter(competition.getEndTime())) {
            throw new UnsupportedActionException("Cannot add Hunts, competition is expired");
        }

        if (huntingRequest.fish().averageWeight() < fish.getAverageWeight()) {
            throw new UnsupportedActionException("The Fish " + huntingRequest.fish().name() + "'s weight ("+ huntingRequest.fish().averageWeight() +") must be equal to "  + fish.getAverageWeight());
        }

        RankId rankId = new RankId(member, competition);
        Ranking ranking = rankingRepository.findById(rankId)
                .orElseThrow(() -> new UnsupportedActionException("cannot add hunts to a member who is not in a competition"));


        Optional<Hunting> hunting = huntingRepository.findHuntingByCompetitionAndUserAndFish(competition, member, fish);
        Hunting hunt;
        if (hunting.isPresent()) {
            hunt = hunting.get();
            hunt.setNumberOfFish(hunt.getNumberOfFish() + huntingRequest.numberOfFish());
            ranking.setScore(ranking.getScore() + (hunt.getFish().getLevel().getPoints() * huntingRequest.numberOfFish()));
        }else {
            hunt = new Hunting();
            hunt.setCompetition(competition);
            hunt.setUser(member);
            hunt.setFish(fish);
            hunt.setNumberOfFish(huntingRequest.numberOfFish());
            ranking.setScore(ranking.getScore() + (hunt.getFish().getLevel().getPoints() + huntingRequest.numberOfFish()));
        }
        rankingRepository.save(ranking);
        Hunting savedHunt = huntingRepository.save(hunt);
        return Optional.of(mapper.toResponse(savedHunt));
    }
}
