package com.rentirs.security.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AuthenticationDTO {
    @NotEmpty(message = "Имя не должно быть пустым")
    @Size(min = 2, max = 100, message = "Длина имени должна быть от 2 до 100 символов")
    private String username;
    private String password;
}
