/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.spring.fundamentosJ11.fundamentosJ11.repository;
 
import com.spring.fundamentosJ11.fundamentosJ11.DTO.UserDto;
import com.spring.fundamentosJ11.fundamentosJ11.Entity.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author juanj
 */
@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long>{
        //JpaRepository<User, Long>{
    
    
   
    /**
     * Metodo que ocupa JPQL para buscar en la base de datos por email
     * @param email
     * @return 
     */
    @Query("SELECT u "
            + "from User u "
            + "where 1 = 1 "
            + "and u.email =?1"
    )
    Optional<User> findBYUserEmail(String email);
    
    /**
     * Metodo que ayuda a buscar por nombre de usuario y ordena los resultados 
     * regresa una lista de valores
     * @param name
     * @param sort
     * @return 
    */
     @Query("select u "
             + "from User u "
             + "where 1 = 1"
             + "and u.name like ?1%")
    List<User> findByAndSort(String name, Sort sort);
    
    /***
     * Query methods para buscar por nombre y por nombre y correo
     * 
     * @param name
     * @return 
     */
    List<User> findByName(String name);
    
    Optional<User> findByEmailAndName(String email, String name);
    
    
    List<User> findByNameLike(String name);
    
    List<User> findByNameOrEmail(String name, String email);
    
    List<User> findByBirthDateBetween(LocalDate begin, LocalDate end);
    
    //List<User> findByNameContainingOrderByIdDesc(String name);
    
    @Query("select new com.spring.fundamentosJ11.fundamentosJ11.DTO.UserDto(u.id, u.name, u.birthDate)"
              + "from User u "
              + "where u.birthDate =:parametroFecha"
            //  + "and u.email =:parametroEmail"
    )
    Optional<UserDto> getAllByBirthDateAndEmail(@Param("parametroFecha")LocalDate date
                                            //   ,@Param("parametroEmail")String email
                                                );

     List<User> findAll();
}