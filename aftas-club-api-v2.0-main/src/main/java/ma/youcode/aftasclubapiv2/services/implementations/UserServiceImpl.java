package ma.youcode.aftasclubapiv2.services.implementations;

import lombok.RequiredArgsConstructor;
import ma.youcode.aftasclubapiv2.dto.requests.UserRequest;
import ma.youcode.aftasclubapiv2.dto.responses.UserResponse;
import ma.youcode.aftasclubapiv2.entities.User;
import ma.youcode.aftasclubapiv2.exceptions.ResourceNotFoundException;
import ma.youcode.aftasclubapiv2.mapper.UserMapper;
import ma.youcode.aftasclubapiv2.repositories.UserRepository;
import ma.youcode.aftasclubapiv2.services.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl extends AbstractServiceImpl<UUID, UserRequest, UserResponse, User, UserRepository, UserMapper> implements UserService, UserDetailsService {

    private final UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByEmail(username)
                .orElseThrow(() -> new ResourceNotFoundException("No User Found with email: " + username));
    }
}
