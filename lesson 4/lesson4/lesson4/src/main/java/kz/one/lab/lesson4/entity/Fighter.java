package kz.one.lab.lesson4.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name = "fighter")
@NoArgsConstructor
@Getter
@Setter
@Component
@JsonSerialize
public class Fighter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    String name = "Незванный Гость";
    int strength;
    int agility;
    int skill;

    public int getPowerLevel(){
        return strength+agility+skill;
    }

    @Override
    public String toString() {
        return "Fighter{" +
                "name='" + name + '\'' +
                '}';
    }
}
