package com.fedex.homeworkapp.user.utility;

import com.fedex.homeworkapp.user.utility.emailValidation.ValidEmail;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
public class ApplicationUserDTO {

    Long id;

    @NotBlank
    String username;
    @ValidEmail
    @NotBlank
    String email;
    @NotBlank
    String password;
    List<Role> roles;

}
