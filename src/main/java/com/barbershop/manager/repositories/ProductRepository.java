package com.barbershop.manager.repositories;

import com.barbershop.manager.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // You can add custom query methods here if needed
}
