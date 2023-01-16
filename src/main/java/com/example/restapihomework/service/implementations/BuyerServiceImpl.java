package com.example.restapihomework.service.implementations;

import com.example.restapihomework.dto.BuyerDto;
import com.example.restapihomework.model.Buyer;
import com.example.restapihomework.repository.BuyerRepository;
import com.example.restapihomework.service.interfaces.BuyerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BuyerServiceImpl implements BuyerService {

  private final BuyerRepository repository;

  @Autowired
  public BuyerServiceImpl(BuyerRepository repository) {
    this.repository = repository;
  }


  @Override
  public List<BuyerDto> getAllBuyers(Pageable pageable, int page) {
    Pageable updatedPageable = PageRequest.of(-1, pageable.getPageSize());
    Page<BuyerDto> buyerPage = repository.findAll(updatedPageable).map(BuyerDto::createBuyerDto);
    return buyerPage.getContent();
  }
}
