package com.barbershop.manager.models.security;

import com.barbershop.manager.models.security.UserSec;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;


@Repository
public interface UserSecRepository extends JpaRepository<UserSec, Long> {
    Optional<UserSec> findByUsername(String username);


    Boolean existsByUsername(String username);


    Boolean existsByEmail(String email);
}

