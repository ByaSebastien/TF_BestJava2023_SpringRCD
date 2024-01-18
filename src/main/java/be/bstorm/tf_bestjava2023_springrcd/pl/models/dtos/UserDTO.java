package be.bstorm.tf_bestjava2023_springrcd.pl.models.dtos;

import be.bstorm.tf_bestjava2023_springrcd.dl.entities.User;
import be.bstorm.tf_bestjava2023_springrcd.dl.enums.UserGender;
import be.bstorm.tf_bestjava2023_springrcd.dl.enums.UserRole;

public record UserDTO(
        Long id,
        String lastname,
        String firstname,
        String email,
        UserRole role,
        UserGender gender
) {
    public static UserDTO fromEntity(User u){
        return new UserDTO(
                u.getId(),
                u.getLastname(),
                u.getFirstname(),
                u.getEmail(),
                u.getRole(),
                u.getGender()
        );
    }
}
