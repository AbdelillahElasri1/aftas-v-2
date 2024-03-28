package ma.youcode.aftasclubapiv2.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public abstract class AbstractResponse implements _Response<UUID> {
    /**
     * The unique identifier of the entity.
     */
    private UUID id;

    /**
     * The timestamp when the entity was created.
     */
    private Timestamp createdAt;

    /**
     * The timestamp when the entity was last updated.
     */
    private Timestamp updatedAt;
}
