package com.example.exercisejpa.Model;

import jakarta.persistence.Column;
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
public class MerchantStock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "(must not be empty")
    @Column(columnDefinition = "varchar(10) not null")
    private String productid;
    @NotEmpty(message = "must not be empty")
    @Column(columnDefinition = "varchar(15) not null")
    private String merchantid;
    @NotNull(message = "(must not be empty, have to be more than 10 at start")
    @Max(10)
    @Column(columnDefinition = "int not null ")
    private Integer stock;
}
