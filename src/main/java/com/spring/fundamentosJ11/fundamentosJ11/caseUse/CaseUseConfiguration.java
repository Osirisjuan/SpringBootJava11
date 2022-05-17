/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spring.fundamentosJ11.fundamentosJ11.caseUse;

import com.spring.fundamentosJ11.fundamentosJ11.services.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author juanj
 */
@Configuration
public class CaseUseConfiguration {
    
    @Bean
    GetUser getUser (UserService userService){
        return new getUserImplement(userService);
    }
}
