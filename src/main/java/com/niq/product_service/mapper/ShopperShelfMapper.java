package com.niq.product_service.mapper;

import com.niq.product_service.domain.Product;
import com.niq.product_service.domain.ShopperShelf;
import com.niq.product_service.dto.ProductDto;
import com.niq.product_service.dto.ShelfDto;
import com.niq.product_service.dto.ShopperShelfDto;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.mapstruct.*;

@Mapper(
  componentModel = "spring",
  injectionStrategy = InjectionStrategy.CONSTRUCTOR,
  unmappedTargetPolicy = ReportingPolicy.IGNORE,
  uses = { ProductMapper.class }
)
public interface ShopperShelfMapper {
  //    @Mapping(
  //            target = "productId", source = "productId"
  //    )
  //    @Mapping(
  //            target = "relevancyScore", source = "relevancyScore"
  //    )
  //    ShopperShelf toShopperShelf(ShopperShelfDto shelfDto);
  //
  //    List<ShopperShelf> toEntity(ShopperShelfDto shopperShelfDto);

  @Mappings(
    {
      @Mapping(target = "product.productId", source = "productId"),
      @Mapping(target = "relevancyScore", source = "relevancyScore")
    }
  )
  ShopperShelf toShopperShelf(ShelfDto student);

  @Mappings(
    {
      @Mapping(target = "shopperId", source = "shopperId"),
      @Mapping(target = "product", ignore = true),
      @Mapping(target = "relevancyScore", ignore = true)
    }
  )
  void updateShopperShelfFromShopperShelfDto(
    ShopperShelfDto shopperShelfDto,
    @MappingTarget ShopperShelf shopperShelf
  );

  default List<ShopperShelf> toShopperShelfList(ShopperShelfDto shopperShelfDto) {
    if (shopperShelfDto == null) {
      return null;
    }
    List<ShelfDto> shelfDtoList = shopperShelfDto.getShelf();
    if (shelfDtoList == null) {
      return null;
    }
    if (shelfDtoList.isEmpty()) {
      return Collections.emptyList();
    }
    List<ShopperShelf> shopperShelfList = new ArrayList<>(shelfDtoList.size());
    for (ShelfDto shelfDto : shelfDtoList) {
      ShopperShelf shopperShelf = toShopperShelf(shelfDto);
      updateShopperShelfFromShopperShelfDto(shopperShelfDto, shopperShelf);
      shopperShelfList.add(shopperShelf);
    }
    return shopperShelfList;
  }
}
