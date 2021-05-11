package com.javaSchool.eCare.model.dto.User;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class UserLoginForm {

    @NotNull
    @Email
    private String username;

    @NotNull
    @Size(min = 6, max = 20)
    private String password;
}
