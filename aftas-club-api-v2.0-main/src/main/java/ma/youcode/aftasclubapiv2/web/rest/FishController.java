package ma.youcode.aftasclubapiv2.web.rest;

import lombok.RequiredArgsConstructor;
import ma.youcode.aftasclubapiv2.dto.requests.FishRequest;
import ma.youcode.aftasclubapiv2.dto.responses.FishResponse;
import ma.youcode.aftasclubapiv2.services.FishService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v2/fish")
public class FishController extends _Controller<UUID, FishRequest, FishResponse, FishService> {
}
