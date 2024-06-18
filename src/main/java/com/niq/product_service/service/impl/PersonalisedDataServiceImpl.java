package com.niq.product_service.service.impl;

import com.niq.product_service.dao.PersonalisedDataDao;
import com.niq.product_service.dto.ProductDto;
import com.niq.product_service.service.PersonalisedDataService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonalisedDataServiceImpl implements PersonalisedDataService {

    private final PersonalisedDataDao personalisedDataDao;

    PersonalisedDataServiceImpl(PersonalisedDataDao personalisedDataDao) {
        this.personalisedDataDao = personalisedDataDao;
    }

    @Override
    public List<ProductDto> getProducts(String shopperId, String category, String brand) {
        return personalisedDataDao.getProducts(shopperId, category, brand);
    }

    @Override
    public void save(ProductDto productDto) {
        personalisedDataDao.save(productDto);
    }
}
