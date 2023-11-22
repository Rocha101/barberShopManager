package com.barbershop.manager.repositories;

import com.barbershop.manager.models.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {
    // You can add custom query methods here if needed
}
