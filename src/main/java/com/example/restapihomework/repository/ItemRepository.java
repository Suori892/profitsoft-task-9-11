package com.example.restapihomework.repository;

import com.example.restapihomework.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
  //maybe delete
  void updateById(Integer item_id, Item item);
}
