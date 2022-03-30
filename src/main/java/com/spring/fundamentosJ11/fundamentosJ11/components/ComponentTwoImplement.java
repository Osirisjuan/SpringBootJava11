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
public class ComponentTwoImplement implements ComponentDependency{

    @Override
    public void saludar() {
        System.out.println("Hola desde mi segundo componente");
    }
    
}