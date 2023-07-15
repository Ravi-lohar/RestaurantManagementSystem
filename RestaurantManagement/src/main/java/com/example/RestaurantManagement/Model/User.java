package com.example.RestaurantManagement.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId ;
    @NotBlank
    private String userName ;
    @Email
    @NotBlank
    private String userEmail ;
    @NotBlank
    private String userPassword ;
    @NotBlank
    private String userAddress ;

}
