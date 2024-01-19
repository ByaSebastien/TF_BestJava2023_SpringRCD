package be.bstorm.tf_bestjava2023_springrcd.bll.services.impl;

import be.bstorm.tf_bestjava2023_springrcd.bll.exceptions.user.UserEmailAlreadyExistException;
import be.bstorm.tf_bestjava2023_springrcd.bll.exceptions.user.UserNotFoundException;
import be.bstorm.tf_bestjava2023_springrcd.bll.exceptions.user.UserPasswordException;
import be.bstorm.tf_bestjava2023_springrcd.bll.services.UserService;
import be.bstorm.tf_bestjava2023_springrcd.dal.repositories.UserRepository;
import be.bstorm.tf_bestjava2023_springrcd.dl.entities.User;
import be.bstorm.tf_bestjava2023_springrcd.dl.enums.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findUserByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User with email : " + email + " doesn't exist")
                );
    }

    @Override
    public User register(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new UserEmailAlreadyExistException("User with email " + user.getEmail() + " already exist.");
//            throw new UserEmailAlreadyExistException("User with email " + user.getEmail() + " already exist","UserService","register",32);
        }
        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);
        user.setRole(UserRole.USER);
        return userRepository.save(user);
    }

    @Override
    public User login(User user) {
        User existingUser = userRepository.findUserByEmail(
                user.getEmail()).orElseThrow(() -> new UserNotFoundException("User with email " + user.getEmail() + " not found.")
        );
        if(!passwordEncoder.matches(user.getPassword(), existingUser.getPassword())){
            throw new UserPasswordException();
        }
        return existingUser;
    }
}
