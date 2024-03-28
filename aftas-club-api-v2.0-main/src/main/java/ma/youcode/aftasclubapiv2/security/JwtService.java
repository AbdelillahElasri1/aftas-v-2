package ma.youcode.aftasclubapiv2.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {
    @Value("${application.security.jwt.secret-key}")
    private String securityKey;

    @Value("${application.security.jwt.expiration}")
    private long jwtExpiration;

    @Value("${application.security.jwt.refresh-token.expiration}")
    private long refreshTokenExpiration;

    /**
     * Generates a JWT access token for the given user details.
     *
     * @param userDetails User details for whom the token is generated
     * @return Generated JWT token
     */
    public String generateAccessToken(UserDetails userDetails) {
        return generateToken(new HashMap<>(), userDetails, jwtExpiration);
    }

    /**
     * Generates a JWT refresh token for the given user details.
     *
     * @param userDetails User details for whom the token is generated
     * @return Generated JWT token
     */
    public String generateRefreshToken(UserDetails userDetails) {
        return generateToken(new HashMap<>(), userDetails, refreshTokenExpiration);
    }

    /**
     * Generates a JWT token for the given user details with additional claims.
     *
     * @param extraClaims Additional claims to include in the token
     * @param userDetails User details for whom the token is generated
     * @return Generated JWT token
     */
    private String generateToken(Map<String, Object> extraClaims, UserDetails userDetails, long expiration) {
        return generateJwtToken(extraClaims, userDetails, expiration);
    }

    public String generateJwtToken(Map<String, Object> extraClaims, UserDetails userDetails, long expiration) {
        List<String> roles = userDetails.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .toList();

        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .claim("roles", roles)
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    /**
     * Extracts all claims from a JWT token.
     *
     * @param token JWT token
     * @return all extracted values
     */
    private Claims extractAllClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    /**
     * Extracts the username from a JWT token.
     *
     * @param token JWT token
     * @return Username extracted from the token
     */
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    /**
     * Extracts a specific claim from a JWT token using the provided claims' resolver.
     *
     * @param token          JWT token
     * @param claimsResolver Function to resolve the desired claim from the token's claims
     * @param <T>            Type of the claim
     * @return Extracted claim value
     */
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    /**
     * Validates whether a JWT token is valid for the given user details.
     *
     * @param token       JWT token to be validated
     * @param userDetails User details to validate against
     * @return True if the token is valid, false otherwise
     */
    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    /**
     * Validates whether a JWT token is expired for the given user details.
     *
     * @param token       JWT token to be validated
     * @return True if the token is expired, false otherwise
     */
    public boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    /**
     * Extracts a expiration claim from a JWT token using the extract claim method.
     *
     * @param token       JWT token to be validated
     * @return Extracted expiration value
     */
    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    /**
     * gets the sign in key needed to sign the jwt token.
     * @return {@link SecretKey}
     */
    private SecretKey getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(this.securityKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
