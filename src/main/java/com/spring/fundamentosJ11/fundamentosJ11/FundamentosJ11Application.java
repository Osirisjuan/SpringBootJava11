package com.spring.fundamentosJ11.fundamentosJ11;


import com.spring.fundamentosJ11.fundamentosJ11.components.ComponentDependency; 
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentosJ11Application implements CommandLineRunner{
    
    private ComponentDependency compoDependency;
   
    public FundamentosJ11Application(
            @Qualifier("componentTwoImplement")
               ComponentDependency compoDependency
            ){
        this.compoDependency  = compoDependency;
    };
    
    public static void main(String[] args) {
        SpringApplication.run(FundamentosJ11Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
       compoDependency.saludar(); 
    }

}