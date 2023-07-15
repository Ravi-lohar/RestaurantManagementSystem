package com.example.RestaurantManagement.Respository;

import com.example.RestaurantManagement.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepo extends JpaRepository<Order , Long> {
}
