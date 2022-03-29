/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spring.fundamentosJ11.fundamentosJ11.components;

import org.springframework.stereotype.Component;

/**
 *
 * @author juanj
 */
@Component
public class ComponentImplement implements ComponentDependency{

    @Override
    public void saludar() {
        System.out.println("hola mundo desde mi componente");
    }
    
}
