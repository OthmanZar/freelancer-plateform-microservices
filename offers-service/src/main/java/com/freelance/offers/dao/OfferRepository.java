package com.freelance.offers.dao;

import com.freelance.offers.entities.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferRepository  extends JpaRepository<Offer,Long> {


}
