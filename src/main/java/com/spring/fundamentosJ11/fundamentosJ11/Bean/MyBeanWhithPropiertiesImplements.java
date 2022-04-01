/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spring.fundamentosJ11.fundamentosJ11.Bean;

/**
 *
 * @author juanj
 */
public class MyBeanWhithPropiertiesImplements implements MyBeanWhithPropierties{
    
    private String name;
    private String last_name;
    
    public MyBeanWhithPropiertiesImplements(String name, String last_name) {
        this.name = name;
        this.last_name = last_name;
    }

    @Override
    public String function() {
        return name + " " + last_name;
    }
    
}
