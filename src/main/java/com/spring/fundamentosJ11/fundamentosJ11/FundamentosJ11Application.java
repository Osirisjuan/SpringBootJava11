package com.spring.fundamentosJ11.fundamentosJ11;


import com.spring.fundamentosJ11.fundamentosJ11.Bean.MyBeanWhithPropierties;
import com.spring.fundamentosJ11.fundamentosJ11.Entity.User;
import com.spring.fundamentosJ11.fundamentosJ11.components.ComponentDependency; 
import com.spring.fundamentosJ11.fundamentosJ11.pojo.UserPojo;
import com.spring.fundamentosJ11.fundamentosJ11.repository.UserRepository;
import com.spring.fundamentosJ11.fundamentosJ11.services.UserService;
import java.time.LocalDate; 
import java.util.Arrays;
import java.util.List; 
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;  
@SpringBootApplication
public class FundamentosJ11Application implements CommandLineRunner{
    
    private final Log LOGGER = LogFactory.getLog(FundamentosJ11Application.class);
    private ComponentDependency compoDependency;
    private MyBeanWhithPropierties myBeanWhithPropierties;
    private UserPojo uSerPojo;
    private UserRepository userRepository;
    private UserService userService;
   
    public FundamentosJ11Application(
            @Qualifier("componentTwoImplement")
               ComponentDependency compoDependency,
               MyBeanWhithPropierties myBeanWhithPropierties,
               UserPojo userPojo,
               UserRepository userRepository,
               UserService userService
            ){
        this.compoDependency  = compoDependency;
        this.myBeanWhithPropierties = myBeanWhithPropierties;
        this.uSerPojo= userPojo;
        this.userRepository = userRepository;
        this.userService = userService;
    };
    
    public static void main(String[] args) {
        SpringApplication.run(FundamentosJ11Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
     //  ejemplosAnteriores();
       saveUserInDatabase();
      // getInformationJpqlFromUser();
      // saveWithErrorTransactional();
      
      saveWithErrorTransactional();
    }
    
    private void saveWithErrorTransactional(){
        User test = new User("testinser", "testinsert@gmail.com", LocalDate.of(2021, 12, 10));
        User test1 = new User("testinser1", "testinsert1@gmail.com", LocalDate.of(2021, 11, 10));
        User test2 = new User("testinser2", "testinsert2@gmail.com", LocalDate.of(2021, 10, 10));
        User test3 = new User("testinser3", "testinsert1@gmail.com", LocalDate.of(2021, 10, 10));
        
        List<User> users = Arrays.asList(test, test1, test2, test3 );
        
        try{
            userService.saveTransactional(users);
           
        }catch(Exception e){
            LOGGER.error("ESTA ES UNA EXCEPCION DENTRO DEL METODO   saveTransactional");
        }
         userService.getAllUsers()
                   .stream()
                   .forEach(user ->
                       LOGGER.info("este es el usuario del metodo transact" + user)); 
    }
    private void getInformationJpqlFromUser(){
       LOGGER.info("Usuario con el metodo findBYUserEmail " +
                  userRepository.findBYUserEmail("jhon@gmail.com")
                .orElseThrow(() -> new RuntimeException("No se encontro el usuario")));
        LOGGER.info("***********************************************************************");                        
        
        /**
         * Obtiene uns lista y la recorre con el for each
         */
        userRepository.findByAndSort("Pab", Sort.by("id").descending())
                .stream()
                .forEach(user -> LOGGER.info( "USUARIO CON METODO SORT" + user));
        LOGGER.info("***********************************************************************");
        userRepository.findByName("Pablo")
                .stream()
                .forEach(user -> LOGGER.info("Usuario con query metods findByName " + user ));
        LOGGER.info("***********************************************************************"); 
        LOGGER.info( "usuario con query method findByEmailAndName " + userRepository.findByEmailAndName("jhon@gmail.com", "Jhon")
                .orElseThrow(() -> new RuntimeException("usuario no encontrado")));
        LOGGER.info("***********************************************************************"); 
        userRepository.findByNameLike("%Pab%").stream()
                .forEach(user -> LOGGER.info("Usuario con findByNmaeLike" + user));
        
        userRepository.findByNameOrEmail("Pablo", "pedro@gmail.com").stream()
                .forEach(user -> LOGGER.info("Usuario con findByNameOrEmail" + user));
        
        userRepository.findByBirthDateBetween(LocalDate.of(2021, 03, 10), LocalDate.of(2021, 11, 10)).stream()
                .forEach(user -> LOGGER.info("Usuario con findByBirthDateBetween" + user));
        
       /* userRepository.findByNameContainingOrderByIdDesc("Pab")
                .stream()
                .forEach(user -> LOGGER.info("Usuario encontrado con like y ordenado" + user ));*/
       
       LOGGER.info("El usuraio a parter de name parameter getAllByBirthDateAndEmail " 
                +userRepository.getAllByBirthDateAndEmail(LocalDate.of(2021, 02, 18)/*, "pablo@gmail.com"*/)
               .orElseThrow(()-> 
                      new RuntimeException("no se encontro el parametro atravez de name parameter")));
       
    }
    private void saveUserInDatabase(){
      User user = new User("Jhon", "jhon@gmail.com", LocalDate.of(2021, 03, 10));  
      User user2 = new User("Pedro", "pedro@gmail.com", LocalDate.of(2021, 05, 15));  
      User user4 = new User("Pablo", "pablo@gmail.com", LocalDate.of(2021, 02, 18));  
      User user5 = new User("Pablo", "pablo2@gmail.com", LocalDate.of(2021, 07, 25));  
      User user6 = new User("Pablo3", "pablo3@gmail.com", LocalDate.of(2021, 02, 26));  
      User user7 = new User("Pablo4", "pablo4@gmail.com", LocalDate.of(2021, 11, 18));  
      User user8 = new User("Pablo5", "pablo5@gmail.com", LocalDate.of(2021, 12, 28));  
      User user9 = new User("Pablo6", "pablo6@gmail.com", LocalDate.of(2021, 01, 18));  
      User user10 = new User("Pablo7", "pablo7@gmail.com", LocalDate.of(2021, 02, 14));   
      
      List<User> list = Arrays.asList(user, user2, user4, user10, user5, user6, user7, user8, user9);
      list.stream().forEach(userRepository::save);
    }
    
    public void ejemplosAnteriores(){
        compoDependency.saludar();
        System.err.println("---------------------------");
        System.out.println(myBeanWhithPropierties.function());
        System.out.println(uSerPojo.getEmail() + " - " + uSerPojo.getPassword());
        System.out.println(uSerPojo.getAge());
        System.err.println("---------------------------");
        try{
           //ejemplo de error 
           int value = 10/0;
           LOGGER.debug("mi valor es " + value);
        }catch (Exception e){
           LOGGER.error("esto es un error del aplicativo");            
        }

    }

}