package com.example.restapihomework.service.interfaces;

import com.example.restapihomework.model.Item;
import java.util.List;
import java.util.Optional;

public interface ItemService {

  Optional<Item> getItemById(Integer item_id);

  void createItem(Item newItem);

  void updateItem(Integer item_id, Item updatedItem);

  void deleteItem(Integer item_id);

  List<Item> findAllItemByNameAndCategory(String name, String category);
}
