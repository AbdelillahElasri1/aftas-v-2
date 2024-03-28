package ma.youcode.aftasclubapiv2.web.rest;

import lombok.RequiredArgsConstructor;
import ma.youcode.aftasclubapiv2.dto.requests.LevelRequest;
import ma.youcode.aftasclubapiv2.dto.responses.LevelResponse;
import ma.youcode.aftasclubapiv2.services.LevelService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v2/levels")
public class LevelController extends _Controller<UUID, LevelRequest, LevelResponse, LevelService> {
}
