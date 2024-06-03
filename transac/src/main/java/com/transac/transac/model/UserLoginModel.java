package com.transac.transac.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


@Builder
public class UserLoginModel {
    

    @NotBlank(message = "Email is required")
    @Size(min = 3, max = 50 ,message = "Email must be between 3 and 50 characters")
    private String email;


    @NotBlank(message = "Password is required")
    @Size(min = 3, max = 50 ,message = "Password must be between 3 and 50 characters")
    private String password;
}
