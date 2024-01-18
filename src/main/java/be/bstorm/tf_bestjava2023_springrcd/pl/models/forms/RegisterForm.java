package be.bstorm.tf_bestjava2023_springrcd.pl.models.forms;

import be.bstorm.tf_bestjava2023_springrcd.dl.entities.User;
import be.bstorm.tf_bestjava2023_springrcd.dl.enums.UserGender;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record RegisterForm(

        @NotNull
        @NotBlank
        @Size(max = 50)
        String firstname,

        @NotNull
        @NotBlank
        @Size(max = 50)
        String lastname,

        @NotNull
        @NotBlank
        @Email
        @Size(max = 150)
        String email,

        @NotNull
        @NotBlank
        String password,

        @NotNull
        UserGender gender
) {

    public User toEntity(){
        return new User(
                this.firstname,
                this.lastname,
                this.email,
                this.password,
                this.gender
        );
    }
}
