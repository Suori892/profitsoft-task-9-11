package com.example.restapihomework.dto;

import com.example.restapihomework.model.Buyer;
import com.example.restapihomework.model.Item;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Builder
@Data
public class BuyerDto {
    private Long buyerId;
    @NotBlank(message = "can't be a blank")
    @Size(min = 1, max = 255)
    private String name;
    @NotBlank(message = "can't be a blank")
    @Size(min = 7, max = 255)
    private String email;
    @Nullable
    private List<ItemDto> items;

    public static BuyerDto createBuyerDto(Buyer buyer) {
        return BuyerDto.builder()
                .buyerId(buyer.getBuyerId())
                .name(buyer.getName())
                .email(buyer.getEmail())
                .items(buyer.getItems().stream()
                        .map(ItemDto::createItemDto)
                        .collect(Collectors.toList()))
                .build();
    }
}
