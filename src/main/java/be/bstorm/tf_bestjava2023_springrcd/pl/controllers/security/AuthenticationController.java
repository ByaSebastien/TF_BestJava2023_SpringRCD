package be.bstorm.tf_bestjava2023_springrcd.pl.controllers.security;

import be.bstorm.tf_bestjava2023_springrcd.bll.services.UserService;
import be.bstorm.tf_bestjava2023_springrcd.dl.entities.User;
import be.bstorm.tf_bestjava2023_springrcd.pl.models.dtos.UserDTO;
import be.bstorm.tf_bestjava2023_springrcd.pl.models.dtos.UserTokenDTO;
import be.bstorm.tf_bestjava2023_springrcd.pl.models.forms.RegisterForm;
import be.bstorm.tf_bestjava2023_springrcd.pl.utils.JwtUtils;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {

    private final UserService userService;
    private final JwtUtils jwtUtils;

    @PostMapping("/register")
    public ResponseEntity<UserTokenDTO> register(
            @Valid @RequestBody RegisterForm form
            ){
        User newUser = userService.register(form.toEntity());
        UserDTO dto = UserDTO.fromEntity(newUser);
        String token = jwtUtils.generateToken(newUser);
        UserTokenDTO result = new UserTokenDTO(dto,token);
        return ResponseEntity.ok(result);
    }
}
