package com.example.restapihomework.service.implementations;

import com.example.restapihomework.model.Item;
import com.example.restapihomework.repository.ItemRepository;
import com.example.restapihomework.service.interfaces.ItemService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {
  private ItemRepository repository;

  @Autowired
  public ItemServiceImpl(ItemRepository repository) {
    this.repository = repository;
  }

  @Override
  public Optional<Item> getItemById(Integer item_id) {
    return repository.findById(item_id);
  }

  @Override
  public void createItem(Item newItem) {
    repository.save(newItem);
  }

  @Override
  public void updateItem(Integer item_id, Item updatedItem) {
    Optional<Item> itemForUpdating = repository.findById(item_id);
  }

  @Override
  public void deleteItem(Integer item_id) {
    repository.deleteById(item_id);
  }

  @Override
  public List<Item> findAllItemByNameAndCategory(String name, String category) {
    return null;
  }
}
