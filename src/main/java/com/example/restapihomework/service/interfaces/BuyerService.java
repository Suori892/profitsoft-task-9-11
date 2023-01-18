package com.example.restapihomework.service.interfaces;

import com.example.restapihomework.dto.BuyerDto;
import com.example.restapihomework.model.Buyer;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BuyerService {
  List<BuyerDto> getAllBuyers();
}
