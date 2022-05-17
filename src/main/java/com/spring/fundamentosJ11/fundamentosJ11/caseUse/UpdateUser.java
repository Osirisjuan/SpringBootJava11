/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spring.fundamentosJ11.fundamentosJ11.caseUse;

import com.spring.fundamentosJ11.fundamentosJ11.Entity.User;
import com.spring.fundamentosJ11.fundamentosJ11.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

/**
 *
 * @author juanj
 */
@Component
public class UpdateUser {
    private UserService userService;

    public UpdateUser(UserService userService) {
        this.userService = userService;
    }

    public User updateUser(User newuser, Long id) {
        return userService.updateUser(newuser, id);
    }
    
}
