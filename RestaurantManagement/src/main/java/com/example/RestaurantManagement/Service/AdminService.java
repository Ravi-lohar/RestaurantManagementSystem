package com.example.RestaurantManagement.Service;

import com.example.RestaurantManagement.Model.*;
import com.example.RestaurantManagement.Model.Dto.SignInInput;
import com.example.RestaurantManagement.Model.Dto.SignUpOutput;
import com.example.RestaurantManagement.Respository.HashingUtility.PasswordEncrypter;
import com.example.RestaurantManagement.Respository.IAdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
        @Autowired
        IAdminRepo adminRepo ;

        @Autowired
        AdminAuthenticationService adminAuthenticationService ;

        @Autowired
        FoodItemService foodItemService ;

        public SignUpOutput signUpAdmin(Admin admin) {
                boolean signUpStatus = true;
                String signUpStatusMessage = null;

                String newEmail = admin.getAdminEmail();

                if(newEmail == null)
                {
                        signUpStatusMessage = "Invalid email";
                        signUpStatus = false;
                        return new SignUpOutput(signUpStatus,signUpStatusMessage);
                }


                Admin existingUser = adminRepo.findFirstByAdminEmail(newEmail);

                if(existingUser != null)
                {
                        signUpStatusMessage = "Email already registered!!!";
                        signUpStatus = false;
                        return new SignUpOutput(signUpStatus,signUpStatusMessage);
                }

                //hash the password: encrypt the password
                try {
                        String encryptedPassword = PasswordEncrypter.encryptPassword(admin.getAdminPassword());

                        //saveAppointment the user with the new encrypted password

                        admin.setAdminPassword(encryptedPassword);
                        adminRepo.save(admin);

                        return new SignUpOutput(signUpStatus, "Admin registered successfully!!!");
                }
                catch(Exception e)
                {
                        signUpStatusMessage = "Internal error occurred during sign up";
                        signUpStatus = false;
                        return new SignUpOutput(signUpStatus,signUpStatusMessage);
                }
        }

        public String signInAdmin(SignInInput signInInput) {
                String signInStatusMessage = null;

                String signInEmail = signInInput.getEmail();

                if(signInEmail == null)
                {
                        signInStatusMessage = "Invalid email";
                        return signInStatusMessage;


                }

                //check if this user email already exists ??
                Admin existingUser = adminRepo.findFirstByAdminEmail(signInEmail);

                if(existingUser == null)
                {
                        signInStatusMessage = "Email not registered!!!";
                        return signInStatusMessage;

                }

                //match passwords :

                //hash the password: encrypt the password
                try {
                        String encryptedPassword = PasswordEncrypter.encryptPassword(signInInput.getPassword());
                        if(existingUser.getAdminPassword().equals(encryptedPassword))
                        {
                                //session should be created since password matched and user id is valid
                                AdminAuthenticationToken authToken  = new AdminAuthenticationToken(existingUser);
                                adminAuthenticationService.saveAuthToken(authToken);

                                return "Token created Successfully";
                        }
                        else {
                                signInStatusMessage = "Invalid credentials!!!";
                                return signInStatusMessage;
                        }
                }
                catch(Exception e)
                {
                        signInStatusMessage = "Internal error occurred during sign in";
                        return signInStatusMessage;
                }
        }

        public String sigOutAdmin(String email) {
                Admin admin = adminRepo.findFirstByAdminEmail(email) ;
                AdminAuthenticationToken token = adminAuthenticationService.findFirstByAdmin(admin);
                adminAuthenticationService.removeToken(token);
                return "Admin Signed out successfully";
        }

        public String addFoodItem(FoodItem foodItem) {
                return foodItemService.addFooodItems(foodItem);
        }
}
