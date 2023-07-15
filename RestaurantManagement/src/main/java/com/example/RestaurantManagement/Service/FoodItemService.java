package com.example.RestaurantManagement.Service;

import com.example.RestaurantManagement.Model.FoodItem;
import com.example.RestaurantManagement.Respository.IFoodItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodItemService {
    @Autowired
    IFoodItemRepo foodItemRepo ;

    public String addFooodItems(FoodItem foodItem) {
        foodItemRepo.save(foodItem);
        return "Added" ;
    }

    public Iterable<FoodItem> getFoodItem() {
        return foodItemRepo.findAll();
    }
}
