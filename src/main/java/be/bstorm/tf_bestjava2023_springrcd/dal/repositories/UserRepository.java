package be.bstorm.tf_bestjava2023_springrcd.dal.repositories;

import be.bstorm.tf_bestjava2023_springrcd.dl.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    @Query(
            "select u " +
            "from User u " +
            "where u.email ilike :email")
    Optional<User> findUserByEmail(String email);

    @Query(
            "select count(u) > 0 " +
            "from User u " +
            "where u.email ilike :email")
    boolean existsByEmail(String email);
}
