/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.spring.fundamentosJ11.fundamentosJ11.repository;

import com.spring.fundamentosJ11.fundamentosJ11.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author juanj
 */
@Repository
public interface PostReporsitory extends JpaRepository<Post, Long>{
    
}
