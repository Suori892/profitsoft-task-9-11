package com.example.restapihomework.dto;

import com.example.restapihomework.model.Item;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ItemDto {
    private Long itemId;
    @NotBlank(message = "can't be a blank")
    @Size(min = 1, max = 255)
    private String itemName;
    @NotBlank(message = "can't be a blank")
    @Size(min = 1, max = 255)
    private String itemCategory;
    @NotNull
    private Integer itemPrice;
    @NotNull
    private Long buyerId;

    public static ItemDto createItemDto(Item item) {
        return ItemDto.builder()
                .itemId(item.getItemId())
                .itemName(item.getItemName())
                .itemCategory(item.getItemCategory())
                .itemPrice(item.getItemPrice())
                .buyerId(item.getBuyer().getBuyerId())
                .build();
    }
}
