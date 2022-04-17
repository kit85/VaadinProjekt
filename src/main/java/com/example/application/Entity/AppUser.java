package com.example.application.Entity;

import com.example.application.Repository.AppUserRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.Set;

@Entity
public class AppUser {

    @Id//sätter nyckel
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false,unique = true)
    private String username;

    @Column(nullable = false)
    private String password;




    //en user kan har flera item
    //knyter fast item referensnycekl
    @OneToMany(mappedBy = "appUser")
    @JsonIgnore
    private Set<Item>items;

    public AppUser() {

    }

    public AppUser(String username, String password) {
        this.username = username;
        this.password=password;

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }



    public Set<Item> getItems() {
        return items;
    }

    //komma åt item
    public void setItems(Set<Item> items) {
        this.items = items;
    }
}
