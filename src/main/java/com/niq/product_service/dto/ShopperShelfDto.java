package com.niq.product_service.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShopperShelfDto {
  private String shopperId;
  private List<ShelfDto> shelf;
}
