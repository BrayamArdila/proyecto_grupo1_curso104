package com.example.proyecto_uno.Entidades;

import java.util.UUID;

public class Producto {
    private String id;
    private String name_product;
    private String description;
    private String home;
    private String image;

    public Producto(String id, String name_product, String description, String home, String image) {
        this.id = id;
        this.name_product = name_product;
        this.description = description;
        this.home = home;
        this.image = image;
    }
    public Producto(String name_product, String description, String home, String image) {
        this.id = UUID.randomUUID().toString();
        this.name_product = name_product;
        this.description = description;
        this.home = home;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName_product() {
        return name_product;
    }

    public void setName_product(String name_product) {
        this.name_product = name_product;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
