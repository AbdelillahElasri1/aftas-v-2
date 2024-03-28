package ma.youcode.aftasclubapiv2.mapper;

import ma.youcode.aftasclubapiv2.dto.requests.RankRequest;
import ma.youcode.aftasclubapiv2.dto.responses.RankResponse;
import ma.youcode.aftasclubapiv2.entities.Ranking;
import ma.youcode.aftasclubapiv2.entities.embedded.RankId;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RankingMapper extends AbstractMapper<RankId, RankRequest, RankResponse, Ranking>{
}
