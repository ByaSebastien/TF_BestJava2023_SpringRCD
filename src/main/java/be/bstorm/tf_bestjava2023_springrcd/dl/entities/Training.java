package be.bstorm.tf_bestjava2023_springrcd.dl.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@ToString(of = {"id","name","classroom","beginDate","endDate"})
@EqualsAndHashCode(of = {"id","name","classroom","beginDate","endDate"})
@Table(name = "TRAINING")
public class Training {

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
    @Column(name = "CLASSROOM",nullable = false)
    private String classroom;

    @Getter
    @Setter
    @Temporal(TemporalType.DATE)
    @Column(name = "BEGIN_DATE",nullable = false)
    private LocalDate beginDate;

    @Getter
    @Setter
    @Temporal(TemporalType.DATE)
    @Column(name = "END_DATE",nullable = false)
    private LocalDate endDate;

    @OneToMany(mappedBy = "training")
    private Set<UserTraining> registrations;

    public Training() {
        this.registrations = new HashSet<>();
    }

    public Set<UserTraining> getRegistrations() {
        return Set.copyOf(this.registrations);
    }

    public void addRegistration(UserTraining registration){
        this.registrations.add(registration);
    }

    public void removeRegistration(UserTraining registration){
        this.registrations.remove(registration);
    }
}
