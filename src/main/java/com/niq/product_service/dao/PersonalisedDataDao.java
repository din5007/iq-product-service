package com.niq.product_service.dao;

import com.niq.product_service.dto.ProductDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PersonalisedDataDao {

    List<ProductDto> getProducts(String shopperId, String category, String brand);

    void save(ProductDto productDto);
}
