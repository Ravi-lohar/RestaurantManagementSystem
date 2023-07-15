package com.example.RestaurantManagement.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId ;

    private Integer quantity ;

    @ManyToOne
    @JoinColumn(name = "fk_user_id")
    private User userId ;

    @ManyToOne
    @JoinColumn(name = "fk_foodItem_id")
    private FoodItem foodItemId ;
    @NotBlank
    private String status ;




}
