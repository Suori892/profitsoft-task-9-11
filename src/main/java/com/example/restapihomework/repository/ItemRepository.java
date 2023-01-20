package com.example.restapihomework.repository;

import com.example.restapihomework.model.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    Page<Item> findAllByItemCategoryAndItemName(Pageable pageable, String itemCategory, String itemName);
}
