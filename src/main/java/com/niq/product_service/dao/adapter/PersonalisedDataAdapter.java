package com.niq.product_service.dao.adapter;

import com.niq.product_service.dao.PersonalisedDataDao;
import com.niq.product_service.dto.ProductDto;
import com.niq.product_service.mapper.ProductMapper;
import com.niq.product_service.repository.ProductRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonalisedDataAdapter implements PersonalisedDataDao {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    PersonalisedDataAdapter(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public List<ProductDto> getProducts(String shopperId, String category, String brand) {
        var result = productRepository.findAll();
        return productMapper.toDto(result);
    }

    @Override
    public void save(ProductDto productDto) {
        productRepository.save(productMapper.toProductEntity(productDto));
    }
}
