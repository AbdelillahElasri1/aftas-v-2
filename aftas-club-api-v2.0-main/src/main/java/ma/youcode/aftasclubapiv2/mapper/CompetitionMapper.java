package ma.youcode.aftasclubapiv2.mapper;

import ma.youcode.aftasclubapiv2.dto.requests.CompetitionRequest;
import ma.youcode.aftasclubapiv2.dto.responses.CompetitionResponse;
import ma.youcode.aftasclubapiv2.entities.Competition;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CompetitionMapper extends AbstractMapper<UUID, CompetitionRequest, CompetitionResponse, Competition>{
}
