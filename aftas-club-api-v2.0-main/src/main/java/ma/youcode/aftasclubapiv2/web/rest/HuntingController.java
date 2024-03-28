package ma.youcode.aftasclubapiv2.web.rest;

import lombok.RequiredArgsConstructor;
import ma.youcode.aftasclubapiv2.dto.requests.HuntRequest;
import ma.youcode.aftasclubapiv2.dto.responses.HuntResponse;
import ma.youcode.aftasclubapiv2.services.HuntingService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v2/hunts")
public class HuntingController extends _Controller<UUID, HuntRequest, HuntResponse, HuntingService> {
}
