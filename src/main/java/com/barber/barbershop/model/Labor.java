package com.barber.barbershop.model;

import javax.persistence.*;

@Entity
@Table(name = "labor")
public class Labor extends EntityId{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String description;

    String total_time;

    Integer price;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTotal_time() {
        return total_time;
    }

    public void setTotal_time(String total_time) {
        this.total_time = total_time;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }


}
