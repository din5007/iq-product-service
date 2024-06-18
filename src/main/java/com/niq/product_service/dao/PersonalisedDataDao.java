package com.niq.product_service.dao;

import com.niq.product_service.dto.ProductArgs;
import com.niq.product_service.dto.ProductDto;
import com.niq.product_service.dto.ShopperShelfDto;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public interface PersonalisedDataDao {
  List<ProductDto> getProducts(String shopperId, String category, String brand);

  List<ProductDto> getProducts(ProductArgs productArgs);

  void save(ProductDto productDto);

  void saveShopperInfo(ShopperShelfDto shopperShelfDto);
}
