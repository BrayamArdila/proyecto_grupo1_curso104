package com.example.proyecto_uno.Entidades;

import java.util.UUID;

public class Producto {
    private String id;
    private String name_product;
    private String description;
    private String image;

    public Producto(String id, String name_product, String description, String image) {
        this.id = id;
        this.name_product = name_product;
        this.description = description;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
