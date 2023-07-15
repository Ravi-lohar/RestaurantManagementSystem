package com.example.RestaurantManagement.Service;

import com.example.RestaurantManagement.Model.Order;
import com.example.RestaurantManagement.Respository.IOrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    IOrderRepo orderRepo ;

    public String placeOrder(Order order) {
        orderRepo.save(order) ;
        return "Order Placed Successfully" ;
    }
}
