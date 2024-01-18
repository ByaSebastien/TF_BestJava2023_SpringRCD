package be.bstorm.tf_bestjava2023_springrcd.pl.models.dtos;

public record UserTokenDTO(
        UserDTO user,
        String token
) {
}
