package ma.youcode.aftasclubapiv2.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum UserRole {
    MEMBER("member"),
    ADMIN("admin"),
    JURY("jury");

    private final String userRole;
}
