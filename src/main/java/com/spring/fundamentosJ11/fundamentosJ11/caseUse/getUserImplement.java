/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spring.fundamentosJ11.fundamentosJ11.caseUse;

import com.spring.fundamentosJ11.fundamentosJ11.Entity.User;
import com.spring.fundamentosJ11.fundamentosJ11.services.UserService;
import java.util.List;

/**
 *
 * @author juanj
 */
public class getUserImplement implements  GetUser{

    private UserService userService;

    public getUserImplement(UserService userService) {
        this.userService = userService;
    }
    
    
    
    @Override
    public List<User> getAll() {
        return userService.getAllUsers();
    }
    
}
