package be.bstorm.tf_bestjava2023_springrcd.bll.services;

import be.bstorm.tf_bestjava2023_springrcd.dl.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User register(User user);
}
