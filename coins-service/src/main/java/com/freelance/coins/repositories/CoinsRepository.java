package com.freelance.coins.repositories;

import com.freelance.coins.entities.Coins;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoinsRepository extends JpaRepository<Coins,Long> {

    Coins findByPackName(String packName);

}
