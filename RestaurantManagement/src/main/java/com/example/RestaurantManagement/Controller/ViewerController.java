package com.example.RestaurantManagement.Controller;

import com.example.RestaurantManagement.Model.FoodItem;
import com.example.RestaurantManagement.Service.ViewerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ViewerController {
    @Autowired
    ViewerService viewerService ;

    @GetMapping("foodItem")
    public Iterable<FoodItem> getFoodItem(){
        return viewerService.getFoodItem();
    }
}