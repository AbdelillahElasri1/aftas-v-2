package ma.youcode.aftasclubapiv2.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LevelResponse extends AbstractResponse {
    private String description;
    private Integer points;
}
