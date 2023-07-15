package com.example.RestaurantManagement.Respository;

import com.example.RestaurantManagement.Model.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFoodItemRepo extends JpaRepository<FoodItem , Long> {
}
