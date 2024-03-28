package ma.youcode.aftasclubapiv2.web.rest;

import lombok.RequiredArgsConstructor;
import ma.youcode.aftasclubapiv2.dto.requests.CompetitionRequest;
import ma.youcode.aftasclubapiv2.dto.responses.CompetitionResponse;
import ma.youcode.aftasclubapiv2.services.CompetitionService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v2/competitions")
public class CompetitionController extends _Controller<UUID, CompetitionRequest, CompetitionResponse, CompetitionService> {
}
