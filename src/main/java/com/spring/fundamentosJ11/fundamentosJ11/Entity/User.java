/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spring.fundamentosJ11.fundamentosJ11.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author juanj
 */
@Entity
@Table(name = "user") 
public class User {
    
    /**
     * Se Detallan las columnas que tine la entidad en nla base dedatos.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_user", nullable = false , unique = true)
    private Long id_user;
    
    @Column(length = 50)
    private String name;
    
    @Column(length = 50)
    private String email;
    
    private LocalDate birthDate;
    
    /**
     * Se crea la relacion que se tiene con las demas entidades
     */
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Post> list = new ArrayList<>();

    /**
     * Creamos el contructor
     */
    public User() {
    }
    
    /**
     * Se generan un contructor con los atributos que se tienen en la entidad
     * @param name
     * @param email
     * @param birthDate 
     */
    public User(String name, String email, LocalDate birthDate) {
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
    }
    
    /**
     * Generamos los getters an settters
     * @return 
     */
    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public List<Post> getList() {
        return list;
    }

    public void setList(List<Post> list) {
        this.list = list;
    }

    /**
     * Generamos el metodo to_string
     * @return 
     */
    @Override
    public String toString() {
        return "User{" + "id_user=" + id_user + 
             ", name=" + name + 
             ", email=" + email + 
             ", birthDate=" + birthDate + 
             ", list=" + list + '}';
    }
    
    
}
