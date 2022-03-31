package com.spring.fundamentosJ11.fundamentosJ11;

import com.spring.fundamentosJ11.fundamentosJ11.bean.MyBean;
import com.spring.fundamentosJ11.fundamentosJ11.bean.MyBeanWhitDependency;
import com.spring.fundamentosJ11.fundamentosJ11.components.ComponentDependency; 
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentosJ11Application implements CommandLineRunner{
    
    private ComponentDependency compoDependency;
    private MyBean myBean;
    private MyBeanWhitDependency myBeanWhitDependency;
    public FundamentosJ11Application(
            @Qualifier("componentTwoImplement") ComponentDependency compoDependency, 
            MyBean myBean,
            MyBeanWhitDependency myBeanWhitDependency){
        this.compoDependency  = compoDependency;
        this.myBean = myBean;
        this.myBeanWhitDependency = myBeanWhitDependency;
    };
    
    public static void main(String[] args) {
        SpringApplication.run(FundamentosJ11Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
       compoDependency.saludar();
       myBean.print();
       myBeanWhitDependency.prindwhitdependency();
    }

}