package ma.youcode.aftasclubapiv2.services;

import ma.youcode.aftasclubapiv2.dto.requests.UserRequest;
import ma.youcode.aftasclubapiv2.dto.responses.UserResponse;

import java.util.UUID;

/**
 * Service interface for managing User entities.
 * @author Mohamed Ossalhe
 */
public interface UserService extends _Service<UUID, UserRequest, UserResponse> {
}
