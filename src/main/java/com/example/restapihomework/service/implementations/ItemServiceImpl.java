package com.example.restapihomework.service.implementations;

import com.example.restapihomework.dto.ItemDto;
import com.example.restapihomework.model.Item;
import com.example.restapihomework.repository.ItemRepository;
import com.example.restapihomework.service.interfaces.ItemService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {
  private final ItemRepository repository;

  @Autowired
  public ItemServiceImpl(ItemRepository repository) {
    this.repository = repository;
  }

  @Override
  public Item createItem(ItemDto item) {
    Item newItem = convertItemDtoToItem(item);
    return repository.save(newItem);
  }

  @Override
  public Item updateItem(Long id, ItemDto item) {
    Item newItem = convertItemDtoToItem(item);
    newItem.setItemId(id);
    return repository.save(newItem);
  }

  @Override
  public ItemDto getItem(Long id) {
    Optional<Item> item = repository.findById(id);
    return ItemDto.createItemDto(item.get());
  }

  @Override
  public void deleteItem(Long id) {
    repository.deleteById(id);
  }

  @Override
  public List<ItemDto> findAllByItemCategoryAndItemPrice(Pageable pageable, String category, Integer price, int page) {
    Pageable updatedPageable = PageRequest.of(page - 1, pageable.getPageSize());
    Page<ItemDto> itemPage = repository.findAllByItemCategoryAndItemPrice(updatedPageable, category, price)
            .map(ItemDto::createItemDto);
    return itemPage.getContent();
  }

  private Item convertItemDtoToItem(ItemDto itemDto) {
    Item item = new Item();
    item.setItemName(itemDto.getItemName());
    item.setItemCategory(itemDto.getItemCategory());
    item.setItemPrice(item.getItemPrice());
    return item;
  }
}
