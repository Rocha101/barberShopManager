package com.barber.barbershopmanager.model;

import java.sql.Blob;

public class Products extends EntityId{
    String description;
    Integer quantity;

    Integer price;

    Blob image;

    StatusProduct status;
}
