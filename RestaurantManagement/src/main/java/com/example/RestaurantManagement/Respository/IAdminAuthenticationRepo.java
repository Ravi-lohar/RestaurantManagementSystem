package com.example.RestaurantManagement.Respository;

import com.example.RestaurantManagement.Model.Admin;
import com.example.RestaurantManagement.Model.AdminAuthenticationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAdminAuthenticationRepo extends JpaRepository<AdminAuthenticationToken , Long> {
    AdminAuthenticationToken findFirstByTokenValue(String authTokenValue);
    AdminAuthenticationToken findFirstByAdmin(Admin admin);
}
