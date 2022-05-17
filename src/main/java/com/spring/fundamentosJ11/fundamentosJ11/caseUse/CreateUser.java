/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spring.fundamentosJ11.fundamentosJ11.caseUse;

import com.spring.fundamentosJ11.fundamentosJ11.Entity.User;
import com.spring.fundamentosJ11.fundamentosJ11.FundamentosJ11Application;
import com.spring.fundamentosJ11.fundamentosJ11.services.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

/**
 *
 * @author juanj
 */
@Component
public class CreateUser {
    private UserService userService;
    
    private final Log LOGGER = LogFactory.getLog(FundamentosJ11Application.class);
    
    public CreateUser(UserService userService) {
        this.userService = userService;
    }
    
    public User save (User newUser){
        LOGGER.info("********************************* createuser ***************************");
        return userService.save(newUser);
    }
}
