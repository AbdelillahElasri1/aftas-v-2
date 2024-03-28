package ma.youcode.aftasclubapiv2.services.implementations;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import ma.youcode.aftasclubapiv2.dto.requests.AuthenticationRequest;
import ma.youcode.aftasclubapiv2.dto.requests.UserRequest;
import ma.youcode.aftasclubapiv2.dto.responses.AuthenticationResponse;
import ma.youcode.aftasclubapiv2.entities.User;
import ma.youcode.aftasclubapiv2.enums.IdentityDocumentType;
import ma.youcode.aftasclubapiv2.enums.UserRole;
import ma.youcode.aftasclubapiv2.exceptions.ResourceNotFoundException;
import ma.youcode.aftasclubapiv2.repositories.UserRepository;
import ma.youcode.aftasclubapiv2.security.JwtService;
import ma.youcode.aftasclubapiv2.services.AuthenticationService;
import ma.youcode.aftasclubapiv2.services.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final JwtService jwtService;
    private final UserService userService;
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthenticationResponse register(UserRequest request) {
        return createNewUser(request, UserRole.valueOf(request.role()));
    }

    @Override
    public AuthenticationResponse registerJury(UserRequest request) {
        return createNewUser(request, UserRole.JURY);
    }

    @Override
    public AuthenticationResponse registerMember(UserRequest request) {
        return createNewUser(request, UserRole.MEMBER);
    }

    @Override
    public AuthenticationResponse registerAdmin(UserRequest request) {
        return createNewUser(request, UserRole.ADMIN);
    }

    /**
     * Creates a new user based on the registration request and assigns a specified role.
     * This method involves setting up a new user with the provided details, encoding the password,
     * and saving the user to the database. It then generates JWT access and refresh tokens for the
     * new user and saves these tokens. This process is essential for registering new users and
     * providing them with the necessary tokens to access secured endpoints.
     *
     * @param request The registration request containing the new user's details such as name, email, and password.
     * @param role    The role to be assigned to the new user, which determines the user's permissions and access.
     * @return AuthenticationResponse containing the generated JWT access and refresh tokens.
     */
    @Override
    public AuthenticationResponse createNewUser(UserRequest request, UserRole role) {
        var user = User.builder()
                .name(request.name())
                .email(request.email())
                .familyName(request.familyName())
                .accessionDate(request.accessionDate())
                .identityNumber(request.identityNumber())
                .nationality(request.nationality())
                .identityDocument(IdentityDocumentType.valueOf(request.identityDocument()))
                .password(passwordEncoder.encode(request.password()))
                .role(role)
                .build();
        user.setRole(role);

        var savedUser = repository.save(user);

        String jwtToken = jwtService.generateAccessToken(user);
        String refreshToken = jwtService.generateRefreshToken(user);

        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .email(savedUser.getEmail())
                .username(savedUser.getName())
                .role(String.valueOf(savedUser.getRole()))
                .build();
    }

    /**
     * Authenticates a user and generates new access and refresh tokens.
     *
     * @param request Authentication request containing user credentials
     * @return AuthenticationResponse containing new access and refresh tokens
     */
    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.email(),
                            request.password()
                    )
            );
        } catch (BadCredentialsException ex) {
//            log.error("Authentication failed for user: {}", request.email(), ex);
            throw new BadCredentialsException("Invalid credentials");
        } catch (AuthenticationException ex) {
//            log.error("Authentication failed for user: {}", request.email(), ex);
            throw new ResourceNotFoundException("Authentication failed");
        }
        var user = repository.findByEmail(request.email())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        var jwtToken = jwtService.generateAccessToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);
        repository.save(user);
        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .email(user.getEmail())
                .username(user.getName())
                .role(String.valueOf(user.getRole()))
                .build();
    }

    @Override
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

    @Override
    public Boolean checkToken(String token) {
        return null;
    }
}
