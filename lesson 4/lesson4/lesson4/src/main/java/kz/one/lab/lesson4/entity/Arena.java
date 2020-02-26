package kz.one.lab.lesson4.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "arena")
@NoArgsConstructor
@Getter
@JsonSerialize
@ToString
@Component
public class Arena {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @Setter
    String name;

    @JsonIgnore
    @Setter
    @OneToMany(fetch = FetchType.LAZY)
    List<Fighter> fighters = new ArrayList<>();
}
