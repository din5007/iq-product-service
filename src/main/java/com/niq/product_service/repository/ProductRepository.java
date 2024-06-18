package com.niq.product_service.repository;

import com.niq.product_service.domain.Product;
import com.niq.product_service.dto.ProductDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
