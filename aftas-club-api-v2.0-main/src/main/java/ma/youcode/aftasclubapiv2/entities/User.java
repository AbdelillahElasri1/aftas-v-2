package ma.youcode.aftasclubapiv2.entities;

import jakarta.persistence.*;
import lombok.*;
import ma.youcode.aftasclubapiv2.enums.IdentityDocumentType;
import ma.youcode.aftasclubapiv2.enums.UserRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@Table(name = "_user")
@AllArgsConstructor
public class User extends AbstractEntity implements UserDetails {
    private String name;
    private String email;
    private String password;
    private String familyName;
    private LocalDate accessionDate;
    private String nationality;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Enumerated(EnumType.STRING)
    private IdentityDocumentType identityDocument;

    @Column(unique = true, nullable = false)
    private String identityNumber;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Hunting> huntsList;

    @OneToMany(mappedBy = "id.user", fetch = FetchType.LAZY)
    private List<Ranking> rankings;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(
                new SimpleGrantedAuthority(role.getUserRole())
        );
    }

    @Override
    public String getUsername() {
        return getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
