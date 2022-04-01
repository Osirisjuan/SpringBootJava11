package com.spring.fundamentosJ11.fundamentosJ11;


import com.spring.fundamentosJ11.fundamentosJ11.Bean.MyBeanWhithPropierties;
import com.spring.fundamentosJ11.fundamentosJ11.components.ComponentDependency; 
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentosJ11Application implements CommandLineRunner{
    
    private ComponentDependency compoDependency;
    private MyBeanWhithPropierties myBeanWhithPropierties;
   
    public FundamentosJ11Application(
            @Qualifier("componentTwoImplement")
               ComponentDependency compoDependency,
               MyBeanWhithPropierties myBeanWhithPropierties
            ){
        this.compoDependency  = compoDependency;
        this.myBeanWhithPropierties = myBeanWhithPropierties;
    };
    
    public static void main(String[] args) {
        SpringApplication.run(FundamentosJ11Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
       compoDependency.saludar();
        System.err.println("---------------------------");
       System.out.println(myBeanWhithPropierties.function());
       System.err.println("---------------------------");
    }

}