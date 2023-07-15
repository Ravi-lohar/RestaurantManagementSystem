package com.example.RestaurantManagement.Service;

import com.example.RestaurantManagement.Model.FoodItem;
import com.example.RestaurantManagement.Respository.IViewerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ViewerService {
    @Autowired
    IViewerRepo viewerRepo ;

    @Autowired
    FoodItemService foodItemService ;
    public  Iterable<FoodItem> getFoodItem() {
        return foodItemService.getFoodItem();
    }
}
