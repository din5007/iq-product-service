package com.niq.product_service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class ProductDto {
  @JsonProperty("productId")
  private String productId;

  @JsonProperty("brand")
  private String brand;

  @JsonProperty("category")
  private String category;
}
