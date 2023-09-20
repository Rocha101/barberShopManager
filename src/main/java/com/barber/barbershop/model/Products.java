package com.barber.barbershop.model;

import javax.persistence.*;

import java.sql.Blob;

@Entity
@Table(name = "products")

public class Products extends EntityId{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "description")
    String description;
    @Column(name = "quantity")
    Integer quantity;

    @Column(name = "price")
    Integer price;

    //    Blob image; <-- Como implementar???
    @Column(name = "image")
    String image;

    @Column(name = "status")
    StatusProduct status;

    public Products(String description, Integer quantity, Integer price, String image, StatusProduct status) {
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.image = image;
        this.status = status;
    }

    public Products() {

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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public StatusProduct getStatus() {
        return status;
    }

    public void setStatus(StatusProduct status) {
        this.status = status;
    }
}
