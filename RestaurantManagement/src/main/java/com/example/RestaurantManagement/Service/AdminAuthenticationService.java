package com.example.RestaurantManagement.Service;

import com.example.RestaurantManagement.Model.Admin;
import com.example.RestaurantManagement.Model.AdminAuthenticationToken;
import com.example.RestaurantManagement.Model.AuthenticationToken;
import com.example.RestaurantManagement.Model.User;
import com.example.RestaurantManagement.Respository.IAdminAuthenticationRepo;
import com.example.RestaurantManagement.Respository.IAuthenticationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminAuthenticationService {
    @Autowired
    IAdminAuthenticationRepo adminAuthenticationRepo ;

    public void saveAuthToken(AdminAuthenticationToken authToken) {
        adminAuthenticationRepo.save(authToken) ;
    }

    public boolean authenticate(String email, String authTokenValue)
    {
        AdminAuthenticationToken authToken = adminAuthenticationRepo.findFirstByTokenValue(authTokenValue);

        if(authToken == null)
        {
            return false;
        }

        String tokenConnectedEmail = authToken.getAdmin().getAdminEmail();

        return tokenConnectedEmail.equals(email);
    }
    public AdminAuthenticationToken findFirstByAdmin(Admin admin) {
        return adminAuthenticationRepo.findFirstByAdmin(admin);
    }

    public void removeToken(AdminAuthenticationToken token) {
        adminAuthenticationRepo.delete(token);
    }
}
