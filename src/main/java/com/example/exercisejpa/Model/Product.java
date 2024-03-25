package com.example.exercisejpa.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
public class Product {
    @Id
    @NotNull(message = "must not be empty")
    private Integer id;
    @NotEmpty(message = "must not be empty, have to be more than 3 length long")
    @Max(3)
    private String name;
    @NotNull(message = "must not be empty, must be positive number")
    private Integer price;
    @NotEmpty(message = "must not be empty")
    private String categoryID;
}
