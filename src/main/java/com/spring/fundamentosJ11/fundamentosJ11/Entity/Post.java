/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.spring.fundamentosJ11.fundamentosJ11.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

/**
 *Los JPa deben de tener la notacion entity con la cual hacemos referencia a que 
 * es una entidad de la base de datos
 * 
 * Al igual que la notacion Table con un nombre.
 * @author juanj
 */
@Entity
@Table(name = "post")
public class Post {
    /**
     * La notacion @Id hace la referencia a clave principal que tienen nuestra 
     * tabla en la base de datos.
     * 
     */
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //identity para que no se siga el contador de otros registros
    @Column(name = "id_post", nullable = false, unique = true)
    private Long id; 
       
    @Column(name = "description", length = 255)
    private String description;
    
    @ManyToOne
    @JoinColumn(name = "user_id") //No necesario para el ejemplo del curso pero se puede explicar
    @JsonBackReference
    private User user;

    public Post() {
    }

    public Post(String description, User user) {
        this.description = description;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Post{" + "id=" + id + 
                ", description=" + description +
                ", user=" + user + '}';
    }
    
    
}
