package be.bstorm.tf_bestjava2023_springrcd.dl.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "USER_TRAINING")
public class UserTraining {

    @EmbeddedId
    private UserTrainingId id;

    @ManyToOne
    @JoinColumn(name = "USER_ID",nullable = false)
    @MapsId(value = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "TRAINING_ID",nullable = false)
    @MapsId(value = "trainingId")
    private Training training;

    @Column(name = "BEGIN_DATE",nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate beginDate;

    @Column(name = "END_DATE",nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate endDate;

    @Embeddable
    @Getter @Setter
    public static class UserTrainingId implements Serializable{

        @Column(name = "USER_ID")
        private Long userId;

        @Column(name = "TRAINING_ID")
        private Long trainingId;
    }
}
