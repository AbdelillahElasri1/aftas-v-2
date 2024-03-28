package ma.youcode.aftasclubapiv2.dto.requests;

import java.time.LocalDate;

public record UserRequest(
        String name,
        String email,
        String password,
        String familyName,
        LocalDate accessionDate,
        String nationality,
        String role,
        String identityDocument,
        String identityNumber
) implements _Request {
}
