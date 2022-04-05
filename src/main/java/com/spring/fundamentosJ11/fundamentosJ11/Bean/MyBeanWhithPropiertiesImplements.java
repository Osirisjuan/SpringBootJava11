/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spring.fundamentosJ11.fundamentosJ11.Bean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author juanj
 */
public class MyBeanWhithPropiertiesImplements implements MyBeanWhithPropierties{
    
    private String name;
    private String last_name;
    Log LOGGER = LogFactory.getLog(MyBeanWhithPropiertiesImplements.class);
    
    public MyBeanWhithPropiertiesImplements(String name, String last_name) {
        this.name = name;
        this.last_name = last_name;
    }

    @Override
    public String function() {
        LOGGER.info("Este es un mensaje de informacion deade MyBeanWhithPropiertiesImplements");
        return name + " " + last_name;
    }
    
}
