package com.transac.transac.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRegisterModel {
    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 50 ,message = "Name must be between 3 and 50 characters")
    private String name;


    @NotBlank(message = "Email is required")
    @Size(min = 3, max = 50 ,message = "Email must be between 3 and 50 characters")
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 3, max = 50 ,message = "Password must be between 3 and 50 characters")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$", message = "Password must contain at least one uppercase letter, one lowercase letter, and one number")
    private String password;



    
}
