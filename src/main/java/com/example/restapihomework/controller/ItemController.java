package com.example.restapihomework.controller;

import com.example.restapihomework.dto.ItemDto;
import com.example.restapihomework.service.interfaces.ItemService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/item", produces = "application/json")
public class ItemController {
    private final int PAGE_SIZE = 5;

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

    @DeleteMapping("delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteItem(@PathVariable("id") Long id) {
        itemService.deleteItem(id);
    }
}
