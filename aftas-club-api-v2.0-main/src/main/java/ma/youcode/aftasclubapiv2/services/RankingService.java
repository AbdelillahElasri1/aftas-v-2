package ma.youcode.aftasclubapiv2.services;

import ma.youcode.aftasclubapiv2.dto.requests.RankRequest;
import ma.youcode.aftasclubapiv2.dto.responses.RankResponse;
import ma.youcode.aftasclubapiv2.entities.embedded.RankId;

import java.util.List;

public interface RankingService extends _Service<RankId, RankRequest, RankResponse> {
    List<RankResponse> getTopRankPodium(String code);
    List<RankResponse> calcRanking(String code);
}
