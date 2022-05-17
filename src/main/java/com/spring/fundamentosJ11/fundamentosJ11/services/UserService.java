/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spring.fundamentosJ11.fundamentosJ11.services;

import com.spring.fundamentosJ11.fundamentosJ11.Entity.User;
import com.spring.fundamentosJ11.fundamentosJ11.repository.UserRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

/**
 *
 * @author juanj
 */
@Service
public class UserService {
    private final Log LOGGER = LogFactory.getLog(UserService.class);   
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
   @Transactional
    public void saveTransactional(List<User> users ){
        users.stream()
                .peek(user -> LOGGER.info("Usuario insertado " + user))
                .forEach(userRepository::save);
                //.forEach(user -> userRepository.save(user));
    }
    
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    
    public User save(User newUser){
        return userRepository.save(newUser);
    }

    public void delete(Long id) {
        userRepository.delete(new User(id));
    }

    public User updateUser(User newuser, Long id) {
      return  userRepository.findById(id)
                .map(
                        user -> {
                            user.setEmail(newuser.getEmail());
                            user.setBirthDate(newuser.getBirthDate());
                            user.setName(newuser.getName());
                            return userRepository.save(user);
                         }
                ).get(); 
     }
}
