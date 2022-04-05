package com.spring.fundamentosJ11.fundamentosJ11;


import com.spring.fundamentosJ11.fundamentosJ11.Bean.MyBeanWhithPropierties;
import com.spring.fundamentosJ11.fundamentosJ11.components.ComponentDependency; 
import com.spring.fundamentosJ11.fundamentosJ11.pojo.UserPojo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentosJ11Application implements CommandLineRunner{
    
    private final Log LOGGER = LogFactory.getLog(FundamentosJ11Application.class);
    private ComponentDependency compoDependency;
    private MyBeanWhithPropierties myBeanWhithPropierties;
    private UserPojo uSerPojo;
   
    public FundamentosJ11Application(
            @Qualifier("componentTwoImplement")
               ComponentDependency compoDependency,
               MyBeanWhithPropierties myBeanWhithPropierties,
               UserPojo userPojo
            ){
        this.compoDependency  = compoDependency;
        this.myBeanWhithPropierties = myBeanWhithPropierties;
        this.uSerPojo= userPojo;
    };
    
    public static void main(String[] args) {
        SpringApplication.run(FundamentosJ11Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
       compoDependency.saludar();
        System.err.println("---------------------------");
       System.out.println(myBeanWhithPropierties.function());
        System.out.println(uSerPojo.getEmail() + " - " + uSerPojo.getPassword());
        System.out.println(uSerPojo.getAge());
       System.err.println("---------------------------");
       LOGGER.error("esto es un error del aplicativo");
    }

}