package ma.youcode.aftasclubapiv2.services;

import ma.youcode.aftasclubapiv2.dto.requests.CompetitionRequest;
import ma.youcode.aftasclubapiv2.dto.requests.UserRequest;
import ma.youcode.aftasclubapiv2.dto.responses.CompetitionResponse;
import org.springframework.data.domain.Page;

import java.util.UUID;

public interface CompetitionService extends _Service<UUID, CompetitionRequest, CompetitionResponse>{
    Page<CompetitionResponse> getUserCompetitions(UserRequest userRequest);
}
