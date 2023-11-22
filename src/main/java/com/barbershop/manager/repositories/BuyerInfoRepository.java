package com.barbershop.manager.repositories;

import com.barbershop.manager.models.BuyerInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyerInfoRepository extends JpaRepository<BuyerInfo, Long> {
    // You can add custom query methods here if needed
}

