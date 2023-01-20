package com.example.restapihomework.service.interfaces;

import com.example.restapihomework.dto.ItemDto;
import com.example.restapihomework.model.Item;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ItemService {
    Item createItem(ItemDto item);
    Item updateItem(Long id, ItemDto item);
    ItemDto getItem(Long id);
    void deleteItem(Long id);
    List<ItemDto> findAllByItemCategoryAndItemPrice(Pageable pageable, String category, String name, int page);
}
