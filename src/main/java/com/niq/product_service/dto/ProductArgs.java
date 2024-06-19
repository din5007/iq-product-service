package com.niq.product_service.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductArgs {
  public String shopperId;
  public String brand;
  public String category;
  private int limit;
}
