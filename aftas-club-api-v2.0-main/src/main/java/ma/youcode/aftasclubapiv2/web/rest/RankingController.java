package ma.youcode.aftasclubapiv2.web.rest;

import lombok.RequiredArgsConstructor;
import ma.youcode.aftasclubapiv2.dto.requests.RankRequest;
import ma.youcode.aftasclubapiv2.dto.responses.RankResponse;
import ma.youcode.aftasclubapiv2.entities.embedded.RankId;
import ma.youcode.aftasclubapiv2.services.RankingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v2/rankings")
public class RankingController extends _Controller<RankId, RankRequest, RankResponse, RankingService> {
    private final RankingService rankingService;
    @GetMapping("/{code}/podium")
    public ResponseEntity<List<RankResponse>> getTopRankPodium(@PathVariable String code) {
        return new ResponseEntity<>(rankingService.calcRanking(code), HttpStatus.OK);
    }
}
