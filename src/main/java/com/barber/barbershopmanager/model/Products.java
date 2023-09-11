package com.barber.barbershopmanager.model;

import jakarta.persistence.*;

import java.sql.Blob;

@Entity
@Table(name = "products")

public class Products extends EntityId{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    String description;
    Integer quantity;

    Integer price;

    Blob image;

    StatusProduct status;

    public Products(String description, Integer quantity, Integer price, Blob image, StatusProduct status) {
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.image = image;
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }

    public StatusProduct getStatus() {
        return status;
    }

    public void setStatus(StatusProduct status) {
        this.status = status;
    }
}
