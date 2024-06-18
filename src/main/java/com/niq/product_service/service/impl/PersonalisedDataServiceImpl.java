package com.niq.product_service.service.impl;

import com.niq.product_service.dao.PersonalisedDataDao;
import com.niq.product_service.dto.ProductArgs;
import com.niq.product_service.dto.ProductDto;
import com.niq.product_service.dto.ShopperShelfDto;
import com.niq.product_service.service.PersonalisedDataService;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

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
    public List<ProductDto> getProducts(ProductArgs productArgs) {
        return personalisedDataDao.getProducts(productArgs);
    }

    @Override
  public void save(ProductDto productDto) {
    personalisedDataDao.save(productDto);
  }

  @Override
  public void saveShopperInfo(ShopperShelfDto shopperShelfDto) {
    personalisedDataDao.saveShopperInfo(shopperShelfDto);
  }
}
