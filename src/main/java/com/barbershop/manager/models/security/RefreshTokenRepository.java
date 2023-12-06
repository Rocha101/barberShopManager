package com.barbershop.manager.models.security;

import com.barbershop.manager.models.security.RefreshToken;
import com.barbershop.manager.models.security.UserSec;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;


import java.util.Optional;


@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    Optional<RefreshToken> findByToken(String token);


    @Modifying
    int deleteByUser(UserSec user);
}
