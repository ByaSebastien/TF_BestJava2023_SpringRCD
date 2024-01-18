package be.bstorm.tf_bestjava2023_springrcd.dal.repositories;

import be.bstorm.tf_bestjava2023_springrcd.dl.entities.UserTraining;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTrainingRepository extends JpaRepository<UserTraining, UserTraining.UserTrainingId> {
}
