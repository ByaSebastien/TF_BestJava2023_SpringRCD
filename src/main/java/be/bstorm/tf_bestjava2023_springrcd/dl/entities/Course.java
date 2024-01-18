package be.bstorm.tf_bestjava2023_springrcd.dl.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@ToString(of = {"id","name","date","isRemote"})
@EqualsAndHashCode(of = {"id","name","date","isRemote"})
@Table(name = "COURSE")
public class Course {

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
    @Temporal(TemporalType.DATE)
    @Column(name = "COURSE_DATE",nullable = false)
    private LocalDate date;

    @Getter
    @Setter
    @Column(name = "IS_REMOTE",nullable = false)
    private boolean isRemote;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "TRAINING_ID")
    private Training training;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "TRAINER_ID")
    private Trainer trainer;
}
