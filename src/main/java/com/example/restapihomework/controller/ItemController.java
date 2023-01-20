package com.example.restapihomework.controller;

import com.example.restapihomework.dto.ItemDto;
import com.example.restapihomework.service.interfaces.ItemService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/item", produces = "application/json")
public class ItemController {
    private final static int PAGE_SIZE = 2;

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }


    @PostMapping("/create")
    public ResponseEntity<Long> createItem(@RequestBody @Valid ItemDto itemDto) {
        return new ResponseEntity<>(itemService.createItem(itemDto).getItemId(), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Long> updateItem(@RequestBody @Valid ItemDto itemDto, @PathVariable("id") Long id) {
        return ResponseEntity.ok(itemService.updateItem(id, itemDto).getItemId());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemDto> getItem(@PathVariable("id") Long id) {
        ItemDto item = itemService.getItem(id);
        return ResponseEntity.ok(item);
    }

    @GetMapping("/categoryAndPrice/{page}")
    public ResponseEntity<List<ItemDto>> findAllByItemCategoryAndItemPrice(@PageableDefault(size = PAGE_SIZE)
                                                                           Pageable pageable, @RequestParam(value = "category") String category,
                                                                           @RequestParam(value = "name") String name, @PathVariable("page") int page) {
        List<ItemDto> itemList = itemService.findAllByItemCategoryAndItemPrice(pageable, category, name, page);
        return ResponseEntity.ok(itemList);
    }

    @DeleteMapping("delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteItem(@PathVariable("id") Long id) {
        itemService.deleteItem(id);
    }
}
