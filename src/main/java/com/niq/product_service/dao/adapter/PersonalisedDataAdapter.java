package com.niq.product_service.dao.adapter;

import com.niq.product_service.dao.PersonalisedDataDao;
import com.niq.product_service.dao.exception.ProductException;
import com.niq.product_service.dto.ProductArgs;
import com.niq.product_service.dto.ProductDto;
import com.niq.product_service.dto.ShopperShelfDto;
import com.niq.product_service.mapper.ProductMapper;
import com.niq.product_service.mapper.ShopperShelfMapper;
import com.niq.product_service.repository.ProductRepository;
import com.niq.product_service.repository.ShopperShelfRepository;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PersonalisedDataAdapter implements PersonalisedDataDao {
  private final ProductRepository productRepository;
  private final ProductMapper productMapper;
  private final ShopperShelfRepository shopperShelfRepository;
  private final ShopperShelfMapper shopperShelfMapper;

  PersonalisedDataAdapter(
    ProductRepository productRepository,
    ProductMapper productMapper,
    ShopperShelfMapper shopperShelfMapper,
    ShopperShelfRepository shopperShelfRepository
  ) {
    this.productRepository = productRepository;
    this.productMapper = productMapper;
    this.shopperShelfMapper = shopperShelfMapper;
    this.shopperShelfRepository = shopperShelfRepository;
  }

  @Override
  public List<ProductDto> getProducts(String shopperId, String category, String brand) {
    var result = productRepository.findAll();
    return productMapper.toDto(result);
  }

  @Override
  public List<ProductDto> getProducts(ProductArgs productArgs) {
    Pageable pageable = Pageable.ofSize(productArgs.getLimit());
    var result = productRepository.getProductByFilters(pageable, productArgs).getContent();
    return productMapper.toDto(result);
  }

  @Override
  public void save(ProductDto productDto) {
    try {
      productRepository.save(productMapper.toProductEntity(productDto));
    } catch (Exception e) {
      log.debug("Unique Constraint Violation : {}", productDto.getProductId());
    }
  }

  @Override
  public void saveShopperInfo(ShopperShelfDto shopperShelfDto) {
    var productList = shopperShelfMapper.toShopperShelfList(shopperShelfDto);
    productList.forEach(
      data -> {
        try {
          var product = productRepository
            .findProduct(data.getProduct().getProductId())
            .orElseThrow();
          data.setProduct(product);
          shopperShelfRepository.save(data);
        } catch (Exception e) {
          log.info(e.getMessage());
        }
      }
    );
  }
}
