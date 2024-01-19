package be.bstorm.tf_bestjava2023_springrcd.pl.models.forms;

import be.bstorm.tf_bestjava2023_springrcd.dl.entities.User;
import be.bstorm.tf_bestjava2023_springrcd.dl.enums.UserGender;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record RegisterForm(

        @NotNull(message = "Le prénom est requis.")
        @NotBlank(message = "Le prénom est requis.")
        @Size(max = 50,message = "Le prénom ne doit pas dépasser 50 caractères.")
        String firstname,

        @NotNull(message = "Le nom est requis.")
        @NotBlank(message = "Le nom est requis.")
        @Size(max = 50,message = "Le nom ne doit pas dépasser 50 caractères.")
        String lastname,

        @NotNull(message = "L'email est requis.")
        @NotBlank(message = "L'email est requis.")
        @Size(max = 150,message = "L'email ne doit pas dépasser 150 caractères.")
        @Email(message = "Le format de l'email n'est pas valide.")
        String email,

        @NotNull(message = "Le mot de passe est requis.")
        @NotBlank(message = "Le mot de passe est requis.")
        String password,

        @NotNull(message = "Le genre est requis.")
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
