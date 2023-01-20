package com.example.restapihomework.service.implementations;

import com.example.restapihomework.dto.BuyerDto;
import com.example.restapihomework.repository.BuyerRepository;
import com.example.restapihomework.service.interfaces.BuyerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuyerServiceImpl implements BuyerService {

    private final BuyerRepository repository;

    @Autowired
    public BuyerServiceImpl(BuyerRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<BuyerDto> getAllBuyers() {
         return repository.findAll().stream().map(BuyerDto::createBuyerDto).toList();
    }
}
