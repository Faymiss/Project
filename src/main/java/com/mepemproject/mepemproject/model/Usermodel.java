package com.mepemproject.mepemproject.model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "login") // Jina la meza kwenye database ya XAMPP
public class Usermodel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username") // Jina la nguzo kwenye meza "login"
    private String username;

    @Column(name = "password") // Jina la nguzo kwenye meza "login"
    private String password;

    // Constructors
    public Usermodel() {
        // Constructor tupu (default) unahitajika kwa JPA
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
