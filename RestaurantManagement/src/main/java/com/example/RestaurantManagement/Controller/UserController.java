package com.example.RestaurantManagement.Controller;

import com.example.RestaurantManagement.Model.Dto.SignInInput;
import com.example.RestaurantManagement.Model.Dto.SignUpOutput;
import com.example.RestaurantManagement.Model.Order;
import com.example.RestaurantManagement.Model.User;
import com.example.RestaurantManagement.Service.AuthenticationService;
import com.example.RestaurantManagement.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
public class UserController {
    @Autowired
    UserService userService ;

    @Autowired
    AuthenticationService authenticationService ;

    @PostMapping("user/signup")
    public SignUpOutput signUpUser(@RequestBody User user)
    {

        return userService.signUpUser(user);
    }

    @PostMapping("user/signIn")
    public String sigInUser(@RequestBody @Valid SignInInput signInInput)
    {
        return userService.signInUser(signInInput);
    }

    @DeleteMapping("user/signOut/{email}/{token}")
    public String sigOutUser(@PathVariable String email, @PathVariable String token)
    {
        if(authenticationService.authenticate(email,token)) {
            return userService.sigOutUser(email);
        }
        else {
            return "Sign out not allowed for non authenticated user.";
        }

    }

    @PostMapping("order/{email}/{token}")
    public String placeOrder(@PathVariable String email, @PathVariable String token , @RequestBody Order order)
    {
        if(authenticationService.authenticate(email,token)) {
            return userService.placeOrder(order) ;
        }
        else {
            return "Order not allowed for non authenticated user.";
        }

    }

}
