package com.example.exercisejpa.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class User {
    @Id
    @NotNull(message = "(must not be empty")
    private Integer id;
    @NotEmpty(message = "(must not be empty, have to be more than 5 length long")
    @Max(5)
    private String username;
    @NotNull(message = "(must not be empty, have to be more than 6 length long, must have\n" +
            "characters and digits")
    @Max(6)
    private Integer password;
    @NotEmpty(message = "(must not be empty, must be valid email)")
    @Email
    private String email;
    @NotEmpty(message = "(must not be empty, have to be in ( “Admin”,”Customer”)")
    private String rol;
    @NotEmpty(message = "must not be empty, have to be positive")
    private String balance;
}
