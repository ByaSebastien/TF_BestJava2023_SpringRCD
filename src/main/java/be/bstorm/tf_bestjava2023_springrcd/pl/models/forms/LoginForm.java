package be.bstorm.tf_bestjava2023_springrcd.pl.models.forms;

import be.bstorm.tf_bestjava2023_springrcd.dl.entities.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record LoginForm(
        @NotNull(message = "L'email est requis.")
        @NotBlank(message = "L'email est requis.")
        @Email(message = "Le format de l'email n'est pas valide.")
        String email,
        @NotNull(message = "Le mot de passe est requis.")
        @NotBlank(message = "Le mot de passe est requis.")
        String password
) {
    public User toEntity() {
        return new User(this.email, this.password);
    }
}
