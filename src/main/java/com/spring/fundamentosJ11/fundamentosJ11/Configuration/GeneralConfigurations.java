/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spring.fundamentosJ11.fundamentosJ11.Configuration;

import com.spring.fundamentosJ11.fundamentosJ11.Bean.MyBeanWhithPropierties;
import com.spring.fundamentosJ11.fundamentosJ11.Bean.MyBeanWhithPropiertiesImplements;
import com.spring.fundamentosJ11.fundamentosJ11.pojo.UserPojo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author juanj
 */
@Configuration
@EnableConfigurationProperties(UserPojo.class)
public class GeneralConfigurations {
    
    /**
     * Ocupamos un valor almacenado en el archivo propierties y lo asignamos a 
     * una variable para que sea utilizada desde cualquier lugar de la aplicación
     */
    @Value("${value.name}")
    private String name;
    
    @Value("${value.last_name}")
    private String last_name;
    
    @Value("${value.random}")
    private String random;
    
    @Bean
    public MyBeanWhithPropierties funcion(){
        return new MyBeanWhithPropiertiesImplements(name, last_name);
    }
}

 
