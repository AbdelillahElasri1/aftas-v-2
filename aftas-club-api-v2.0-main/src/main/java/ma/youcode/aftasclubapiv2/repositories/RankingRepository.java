package ma.youcode.aftasclubapiv2.repositories;

import ma.youcode.aftasclubapiv2.entities.Competition;
import ma.youcode.aftasclubapiv2.entities.Ranking;
import ma.youcode.aftasclubapiv2.entities.User;
import ma.youcode.aftasclubapiv2.entities.embedded.RankId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data JPA repository for the {@link Ranking} entity.
 *
 * @author Mohamed Ossalhe
 */
@Repository
public interface RankingRepository extends JpaRepository<Ranking, RankId> {
    List<Ranking> findDistinctTop3ById_CompetitionOrderByScoreDesc(Competition competition);
    List<Ranking> findAllById_CompetitionOrderByScoreDesc(Competition competition);

    List<Ranking> findAllById_User(User user);
}
