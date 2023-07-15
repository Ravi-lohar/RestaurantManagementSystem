package com.example.RestaurantManagement.Respository;

import com.example.RestaurantManagement.Model.Admin;
import com.example.RestaurantManagement.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAdminRepo extends JpaRepository<Admin , Long> {


    Admin findFirstByAdminEmail(String newEmail);
}
