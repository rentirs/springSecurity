

package com.rentirs.security.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Имя не должно быть пустым")
    @Size(min = 2, max = 100, message = "Длина имени должна быть от 2 до 100 символов")
    private String username;
    @Column(name = "year_of_birth")
    @Min(value = 1900, message = "Год должен быть больше 1900")
    private int yearOfBirth;

    @Column(name = "role")
    private String role;

    private String password;
}
