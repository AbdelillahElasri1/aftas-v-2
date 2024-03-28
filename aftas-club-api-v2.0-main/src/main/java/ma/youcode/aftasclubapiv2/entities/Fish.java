package ma.youcode.aftasclubapiv2.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Fish extends AbstractEntity {
    private String name;
    private Integer averageWeight;

    @OneToMany(mappedBy = "fish", fetch = FetchType.LAZY)
    private List<Hunting> huntsList;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "level_id")
    private Level level;
}
