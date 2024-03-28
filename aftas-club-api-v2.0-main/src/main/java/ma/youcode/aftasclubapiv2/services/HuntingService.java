package ma.youcode.aftasclubapiv2.services;

import ma.youcode.aftasclubapiv2.dto.requests.HuntRequest;
import ma.youcode.aftasclubapiv2.dto.responses.HuntResponse;

import java.util.UUID;

public interface HuntingService extends _Service<UUID, HuntRequest, HuntResponse> {
}
