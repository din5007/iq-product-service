package com.niq.product_service.service;

import com.niq.product_service.dto.ProductDto;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public interface PersonalisedDataService {

    List<ProductDto> getProducts(String shopperId, String category, String brand);

    void save(ProductDto productDto);
}
