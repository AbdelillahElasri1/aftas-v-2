package ma.youcode.aftasclubapiv2.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ma.youcode.aftasclubapiv2.entities.embedded.RankId;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RankResponse implements _Response<RankId> {
    private Integer rank;
    private Integer score;
    private UserResponse user;
}
