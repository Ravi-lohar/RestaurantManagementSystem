package com.example.RestaurantManagement.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "RestaurantAdmin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adminId ;
    @NotBlank
    private String adminName ;
    @Email
    @Pattern(regexp = ".+@admin\\.com$")
    private String adminEmail ;
    @NotBlank
    private String adminPassword ;
}
