package com.example.restapihomework.controller;

import com.example.restapihomework.dto.BuyerDto;
import com.example.restapihomework.service.interfaces.BuyerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/buyer", produces = "application/json")
public class BuyerController {
    private final BuyerService buyerService;

    public BuyerController(BuyerService buyerService) {
        this.buyerService = buyerService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<BuyerDto>> getAllBuyers() {
        List<BuyerDto> allBuyers = buyerService.getAllBuyers();
        return ResponseEntity.ok(allBuyers);
    }
}
