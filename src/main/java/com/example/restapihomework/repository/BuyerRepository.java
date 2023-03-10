package com.example.restapihomework.repository;

import com.example.restapihomework.model.Buyer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyerRepository extends JpaRepository<Buyer, Long> {
    Page<Buyer> findAll(Pageable pageable);
}
