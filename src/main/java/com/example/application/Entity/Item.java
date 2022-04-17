package com.example.application.Entity;
import javax.persistence.*;

import org.springframework.beans.factory.annotation.Autowired;
import javax.validation.constraints.NotBlank;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false,unique = true)
    @NotBlank
    private String product;
    @Column (nullable = false)
    @NotBlank
    private String brand;
    @Column (nullable = false)
    private int antal;

    //ägande sida
    //manny to one relation till klassen AppUser
    @ManyToOne
    //vår referens nyckel i appuser
    //referensnyckel
    @JoinColumn(name="appuser_id")
    private AppUser appUser;

    //defaultkonstruktor
    public Item() {

    }

    public Item(String product, String brand,int antal, AppUser appUser) {
        this.product = product;
        this.brand = brand;
        this.antal=antal;
        this.appUser=appUser;
    }

    public int getAntal() {
        return antal;
    }

    public void setAntal(int antal) {
        this.antal = antal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }


    //komma åt appuser
    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }
}


