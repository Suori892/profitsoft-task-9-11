package com.example.restapihomework.controller;

import com.example.restapihomework.dto.BuyerDto;
import com.example.restapihomework.service.interfaces.BuyerService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/buyer", produces = "application/json")
public class BuyerController {
    private final int PAGE_SIZE = 5;

    private final BuyerService buyerService;

    public BuyerController(BuyerService buyerService) {
        this.buyerService = buyerService;
    }

    @GetMapping("/all/{page}")
    public ResponseEntity<List<BuyerDto>> getAllBuyers(@PageableDefault(size = PAGE_SIZE) Pageable pageable, @PathVariable("page") int page) {
        List<BuyerDto> allBuyers = buyerService.getAllBuyers(pageable, page);
        return ResponseEntity.ok(allBuyers);
    }
}
