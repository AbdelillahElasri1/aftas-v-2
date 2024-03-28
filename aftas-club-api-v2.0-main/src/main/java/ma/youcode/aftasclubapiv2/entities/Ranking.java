package ma.youcode.aftasclubapiv2.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ma.youcode.aftasclubapiv2.entities.embedded.RankId;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Ranking implements _Entity<RankId> {
    @EmbeddedId
    RankId id;

    @Column(columnDefinition = "INT DEFAULT 0")
    private Integer rank;

    @Column(columnDefinition = "INT DEFAULT 0")
    private Integer score;

    @CreationTimestamp
    @ReadOnlyProperty
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "created_at", nullable = false, updatable = false)
    private Timestamp createdAt;

    /**
     * The timestamp indicating when the entity was last updated.
     */
    @CreationTimestamp
    @ReadOnlyProperty
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "updated_at", nullable = false, updatable = false)
    private Timestamp updatedAt;
}
