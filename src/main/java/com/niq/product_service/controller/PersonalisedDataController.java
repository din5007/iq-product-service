package com.niq.product_service.controller;

import com.niq.product_service.dto.ProductDto;
import com.niq.product_service.service.PersonalisedDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PersonalisedDataController {

    private PersonalisedDataService personalisedDataService;

    @Autowired
    PersonalisedDataController(PersonalisedDataService personalisedDataService) {
        this.personalisedDataService = personalisedDataService;
    }

    @GetMapping("/products")
    public List<ProductDto> getProductsByShopperId(@RequestParam String shopperId, @RequestParam(required = false) String category, @RequestParam(required = false) String brand) {
        return personalisedDataService.getProducts(shopperId, category, brand);
    }

    @PostMapping(value = "/product", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> saveProduct(@RequestBody ProductDto productDto) {
        personalisedDataService.save(productDto);
        return ResponseEntity.ok(Boolean.TRUE);
    }
}
