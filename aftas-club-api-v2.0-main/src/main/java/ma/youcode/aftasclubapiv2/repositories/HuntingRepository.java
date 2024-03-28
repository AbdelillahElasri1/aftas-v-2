package ma.youcode.aftasclubapiv2.repositories;

import ma.youcode.aftasclubapiv2.entities.Competition;
import ma.youcode.aftasclubapiv2.entities.Fish;
import ma.youcode.aftasclubapiv2.entities.Hunting;
import ma.youcode.aftasclubapiv2.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

/**
 * Spring Data JPA repository for the {@link Hunting} entity.
 *
 * @author Mohamed Ossalhe
 */
@Repository
public interface HuntingRepository extends JpaRepository<Hunting, UUID> {
    Optional<Hunting> findHuntingByCompetitionAndUserAndFish(Competition competition, User user, Fish fish);
}
