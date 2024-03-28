package ma.youcode.aftasclubapiv2.repositories;

import ma.youcode.aftasclubapiv2.entities.Fish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

/**
 * Spring Data JPA repository for the {@link Fish} entity.
 *
 * @author Mohamed Ossalhe
 */
@Repository
public interface FishRepository extends JpaRepository<Fish, UUID> {
    Optional<Fish> findByName(String name);
}
