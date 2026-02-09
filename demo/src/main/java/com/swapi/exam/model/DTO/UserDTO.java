package com.swapi.exam.model.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    @NotBlank
    @Size(min = 3, max = 20, message = "Username should be between 3&20 chars.")
    @Pattern(regexp = "^[a-zA-Z0-9._-]+$", message = "Username should contain 1 CL, and no intervals.")
    private String username;
    @NotBlank
    @Size(min = 8)
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*\\d).+$", message = "Password must contain min 8 chars, 1CL and 1 number.")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
