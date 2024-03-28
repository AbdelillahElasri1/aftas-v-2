package ma.youcode.aftasclubapiv2.web.rest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import ma.youcode.aftasclubapiv2.dto.requests.AuthenticationRequest;
import ma.youcode.aftasclubapiv2.dto.requests.UserRequest;
import ma.youcode.aftasclubapiv2.dto.responses.AuthenticationResponse;
import ma.youcode.aftasclubapiv2.services.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v2/auth")
public class AuthenticationController {

    private final AuthenticationService service;

    /**
     * Endpoint for user registration.
     *
     * @param request       The registration request containing user details.
     * @return ResponseEntity with the registered user's authentication response.
     */
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @Valid @RequestBody final UserRequest request
    ) {
        return ResponseEntity.ok(service.register(request));
    }

    /**
     * Endpoint for registering a member.
     * Validates the provided request and, if successful, registers the member and generates authentication tokens.
     *
     * @param request       The registration request containing member details.
     * @return ResponseEntity with the registered member's authentication response.
     */
    @PostMapping("/register/member")
    public ResponseEntity<AuthenticationResponse> registerMember(
            @Valid @RequestBody final UserRequest request
    ) {
        return ResponseEntity.ok(service.registerMember(request));
    }

    /**
     * Endpoint for registering a jury.
     * Validates the provided request and, if successful, registers the jury and generates authentication tokens.
     *
     * @param request       The registration request containing jury details.
     * @return ResponseEntity with the registered manager's authentication response.
     */
    @PostMapping("/register/jury")
    public ResponseEntity<AuthenticationResponse> registerJury(
            @Valid @RequestBody final UserRequest request
    ) {
        return ResponseEntity.ok(service.registerJury(request));
    }

    /**
     * Endpoint for registering an admin.
     * Validates the provided request and, if successful, registers the admin and generates authentication tokens.
     *
     * @param request       The registration request containing agent details.
     * @return ResponseEntity with the registered agent's authentication response.
     */
    @PostMapping("/register/admin")
    public ResponseEntity<AuthenticationResponse> registerAdmin(
            @Valid @RequestBody final UserRequest request
    ) {
        return ResponseEntity.ok(service.registerAdmin(request));
    }

    /**
     * Endpoint for user authentication.
     *
     * @param request       The authentication request containing user credentials.
     * @return ResponseEntity with the authenticated user's response.
     */
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @Valid @RequestBody final AuthenticationRequest request
    ) {
        return ResponseEntity.ok(service.authenticate(request));
    }
}
