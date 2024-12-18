package com.plantify.apiuser.repository;

import com.plantify.apiuser.domain.entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SellerRepository extends JpaRepository<Seller, Long> {

    Optional<Seller> findByName(String sellerName);
}
