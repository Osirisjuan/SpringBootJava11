/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spring.fundamentosJ11.fundamentosJ11.Controller;

import com.spring.fundamentosJ11.fundamentosJ11.Entity.User;
import com.spring.fundamentosJ11.fundamentosJ11.FundamentosJ11Application;
import com.spring.fundamentosJ11.fundamentosJ11.caseUse.CreateUser;
import com.spring.fundamentosJ11.fundamentosJ11.caseUse.DeleteUser;
import com.spring.fundamentosJ11.fundamentosJ11.caseUse.GetUser;
import com.spring.fundamentosJ11.fundamentosJ11.caseUse.UpdateUser;
import com.spring.fundamentosJ11.fundamentosJ11.repository.UserRepository;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author juanj
 */
@RestController
@RequestMapping("/api/users")
public class UserResController {
    
    private GetUser getUser;
    private CreateUser createUser1;
    private DeleteUser deleteUser;
    private UpdateUser updateUser;
    private UserRepository userRepository;
    
     private final Log LOGGER = LogFactory.getLog(FundamentosJ11Application.class);
     
    public UserResController(GetUser getUser
                             ,CreateUser createUSer
                             ,DeleteUser deleteUser
                             ,UpdateUser updateUser
                             , UserRepository userRepository) {
        this.getUser = getUser;
       // this.createUser = createUser;
        this.createUser1 = createUSer;
        this.deleteUser = deleteUser;
        this.updateUser = updateUser;
        this.userRepository = userRepository;
    }
       
    // servicio que nos ayuda a crear
    @GetMapping("/")
    List<User> getAllUseer(){
       return getUser.getAll();
    }
    // Post
    
    @PostMapping("/")
    ResponseEntity<User> newUser(@RequestBody User newuser){
        try {
          return new ResponseEntity<>(createUser1.save(newuser), HttpStatus.CREATED);  
        } catch (Exception e) {
          LOGGER.info("********************************* try cach UserResController ***************************");
          return new ResponseEntity(HttpStatus.METHOD_NOT_ALLOWED);
                  
        }
       
    }
    
    //Deben de tener los mismo identificadores
    @DeleteMapping("/{id}")
    ResponseEntity deleteUser (@PathVariable Long id){
         deleteUser.remove(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
    
    @PutMapping("{id}")
    ResponseEntity<User> replaceUser(@RequestBody User newuser, @PathVariable Long id){
        return new ResponseEntity<>(updateUser.updateUser(newuser, id), HttpStatus.OK);
    }
    
    @GetMapping("/pageable")
    List <User> getUserPageable(@RequestParam int page, @RequestParam int size){
        return userRepository.findAll(PageRequest.of(page, size)).getContent();
    }
}
