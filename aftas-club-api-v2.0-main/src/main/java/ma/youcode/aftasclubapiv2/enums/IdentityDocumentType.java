package ma.youcode.aftasclubapiv2.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum IdentityDocumentType {
    CIN("cin"),
    CART_RESIDENCE("cart_residence"),
    PASSPORT("passport");

    private final String identityDocument;
}
