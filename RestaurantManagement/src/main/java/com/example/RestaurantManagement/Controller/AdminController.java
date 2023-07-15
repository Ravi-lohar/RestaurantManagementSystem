package com.example.RestaurantManagement.Controller;


import com.example.RestaurantManagement.Model.Admin;
import com.example.RestaurantManagement.Model.AdminAuthenticationToken;
import com.example.RestaurantManagement.Model.Dto.SignInInput;
import com.example.RestaurantManagement.Model.Dto.SignUpOutput;

import com.example.RestaurantManagement.Model.FoodItem;
import com.example.RestaurantManagement.Service.AdminAuthenticationService;
import com.example.RestaurantManagement.Service.AdminService;
import com.example.RestaurantManagement.Service.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
public class AdminController {
    @Autowired
    AdminService adminService ;

    @Autowired
    AdminAuthenticationService adminAuthenticationService ;

    @PostMapping("admin/signup")
    public SignUpOutput signUpAdmin (@Valid @RequestBody Admin admin)
    {
        return adminService.signUpAdmin(admin);
    }

    @PostMapping("admin/signIn")
    public String signInAdmin(@RequestBody @Valid SignInInput signInInput)
    {
        return adminService.signInAdmin(signInInput);
    }

    @DeleteMapping("admin/signOut/{email}/{token}")
    public String sigOutAdmin(@PathVariable  String email, @PathVariable  String token)
    {
        if(adminAuthenticationService.authenticate(email,token)) {
            return adminService.sigOutAdmin(email);
        }
        else {
            return "Sign out not allowed for non authenticated Admin.";
        }
    }

    @PostMapping("add/{email}/{token}")
    public String addFoodItem(@PathVariable  String email, @PathVariable String token , @RequestBody FoodItem foodItem)
    {
        if(adminAuthenticationService.authenticate(email,token)) {
            return adminService.addFoodItem(foodItem);
        }
        else {
            return "Adding is not allowed for non authenticated Admin.";
        }
    }

}
