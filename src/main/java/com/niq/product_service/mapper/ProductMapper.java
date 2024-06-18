package com.niq.product_service.mapper;

import com.niq.product_service.domain.Product;
import com.niq.product_service.domain.ShopperShelf;
import com.niq.product_service.dto.ProductDto;
import com.niq.product_service.dto.ShopperShelfDto;
import java.util.List;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(
  componentModel = "spring",
  injectionStrategy = InjectionStrategy.CONSTRUCTOR,
  unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface ProductMapper {
  ProductDto toProductDto(Product product);

  List<ProductDto> toDto(List<Product> ProductEntity);

  @Mapping(source = "productId", target = "productId")
  @Mapping(source = "brand", target = "brand")
  @Mapping(source = "category", target = "category")
  Product toProductEntity(ProductDto productDto);
}
