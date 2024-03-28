package ma.youcode.aftasclubapiv2.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FishResponse extends AbstractResponse {
    private String name;
    private Integer averageWeight;
}
