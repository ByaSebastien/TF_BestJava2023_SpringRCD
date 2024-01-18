package be.bstorm.tf_bestjava2023_springrcd.dl.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@ToString(of = {"id","name","society"})
@EqualsAndHashCode(of = {"id","name","society"})
@Table(name = "TRAINER")
public class Trainer {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Getter
    @Setter
    @Column(name = "NAME",nullable = false,length = 100)
    private String name;

    @Getter
    @Setter
    @Column(name = "SOCIETY",nullable = false,length = 50)
    private String society;
}
