package ma.youcode.aftasclubapiv2.mapper;

import ma.youcode.aftasclubapiv2.dto.requests.UserRequest;
import ma.youcode.aftasclubapiv2.dto.responses.UserResponse;
import ma.youcode.aftasclubapiv2.entities.User;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserMapper extends AbstractMapper<UUID, UserRequest, UserResponse, User>{
}
