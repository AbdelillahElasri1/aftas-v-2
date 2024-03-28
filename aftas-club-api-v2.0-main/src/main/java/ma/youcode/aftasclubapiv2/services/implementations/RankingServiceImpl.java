package ma.youcode.aftasclubapiv2.services.implementations;

import lombok.RequiredArgsConstructor;
import ma.youcode.aftasclubapiv2.dto.requests.RankRequest;
import ma.youcode.aftasclubapiv2.dto.responses.RankResponse;
import ma.youcode.aftasclubapiv2.entities.Competition;
import ma.youcode.aftasclubapiv2.entities.Ranking;
import ma.youcode.aftasclubapiv2.entities.User;
import ma.youcode.aftasclubapiv2.entities.embedded.RankId;
import ma.youcode.aftasclubapiv2.exceptions.MaxLimitsExceedException;
import ma.youcode.aftasclubapiv2.exceptions.ResourceAlreadyExistException;
import ma.youcode.aftasclubapiv2.exceptions.ResourceNotFoundException;
import ma.youcode.aftasclubapiv2.mapper.RankingMapper;
import ma.youcode.aftasclubapiv2.repositories.CompetitionRepository;
import ma.youcode.aftasclubapiv2.repositories.RankingRepository;
import ma.youcode.aftasclubapiv2.repositories.UserRepository;
import ma.youcode.aftasclubapiv2.services.RankingService;
import ma.youcode.aftasclubapiv2.utils.Utils;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RankingServiceImpl extends AbstractServiceImpl<RankId, RankRequest, RankResponse, Ranking, RankingRepository, RankingMapper> implements RankingService
{

    private final UserRepository userRepository;
    private final CompetitionRepository competitionRepository;
    private final RankingRepository rankingRepository;
    private final RankingMapper mapper;

    @Override
    public Optional<RankResponse> create(RankRequest rankingRequest) {
        User member = userRepository.findByEmail(rankingRequest.user().email())
                .orElseThrow(() -> new ResourceNotFoundException("Member not Found with Id: " + rankingRequest.user().email()));
        Competition competition = competitionRepository.getCompetitionByDate(rankingRequest.competition().date())
                .orElseThrow(() -> new ResourceNotFoundException("Competition not Found with Date: " + rankingRequest.competition().date()));
        RankId rankId = new RankId(member, competition);
        if (rankingRepository.findById(rankId).isPresent()) throw new ResourceAlreadyExistException("Member already exist in the competition");
        Long days = Utils.calculateDaysUntilCompetition(competition.getDate());
        if (competition.getRanksList().size() == competition.getNumberOfParticipants())
            throw new MaxLimitsExceedException("Can't add More Members Competition is Already Full.");
        Ranking ranking = new Ranking(rankId, rankingRequest.rank(), rankingRequest.score(), Timestamp.from(Instant.now()), Timestamp.from(Instant.now()));
        Ranking savedRanking = rankingRepository.save(ranking);
        return Optional.of(mapper.toResponse(savedRanking));
    }

    @Override
    public List<RankResponse> getTopRankPodium(String date) {
        Competition competition = competitionRepository.getCompetitionByDate(LocalDate.parse(date))
                .orElseThrow(() -> new ResourceNotFoundException("Competition not Found with code: " + date));
        List<Ranking> rankings = rankingRepository.findDistinctTop3ById_CompetitionOrderByScoreDesc(competition);
        return mapper.toResponse(rankings);
    }

    /**
     *
     * @param date date
     * @return list
     */
    @Override
    public List<RankResponse> calcRanking(String date) {
        Competition competition = competitionRepository.getCompetitionByDate(LocalDate.parse(date))
                .orElseThrow(() -> new ResourceNotFoundException("Competition not Found with code: " + date));
        List<Ranking> rankings = rankingRepository.findAllById_CompetitionOrderByScoreDesc(competition);

        for (int i = 0; i < rankings.size(); i++) {
            rankings.get(i).setRank(i+1);
        }

        List<Ranking> savedRankings = rankingRepository.saveAll(rankings);

        return mapper.toResponse(savedRankings);
    }
}
