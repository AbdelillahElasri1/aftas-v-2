package ma.youcode.aftasclubapiv2.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ma.youcode.aftasclubapiv2.enums.IdentityDocumentType;
import ma.youcode.aftasclubapiv2.enums.UserRole;

import ma.youcode.aftasclubapiv2.entities.User;

import java.time.LocalDate;

/**
 * DTO (Data Transfer Object) representing user-related responses.
 * This class is designed to carry user-related information in a format suitable for response payloads.
 *
 * <p>The fields in this class provide details about the user, including personal information,
 * contact details, and addressing information. It is used to transfer user data between different
 * layers of the application, primarily for response purposes.</p>
 *
 * @see User
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse extends AbstractResponse {
    private String name;
    private String email;
    private String password;
    private String familyName;
    private LocalDate accessionDate;
    private String nationality;

    private UserRole role;

    private IdentityDocumentType identityDocument;

    private String identityNumber;

//    private List<Hunting> huntsList;

//    private List<Ranking> rankings;


}
