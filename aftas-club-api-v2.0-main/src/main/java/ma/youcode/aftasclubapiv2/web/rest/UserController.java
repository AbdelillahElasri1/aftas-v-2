package ma.youcode.aftasclubapiv2.web.rest;

import lombok.RequiredArgsConstructor;
import ma.youcode.aftasclubapiv2.dto.requests.UserRequest;
import ma.youcode.aftasclubapiv2.dto.responses.UserResponse;
import ma.youcode.aftasclubapiv2.entities.User;
import ma.youcode.aftasclubapiv2.mapper.UserMapper;
import ma.youcode.aftasclubapiv2.services.UserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v2/users")
public class UserController extends _Controller<UUID, UserRequest, UserResponse, UserService>{
}
