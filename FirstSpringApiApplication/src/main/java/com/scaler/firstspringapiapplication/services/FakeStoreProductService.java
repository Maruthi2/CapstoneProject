package com.scaler.firstspringapiapplication.services;

import com.scaler.firstspringapiapplication.dtos.FakeStoreProductDto;
import com.scaler.firstspringapiapplication.models.Category;
import com.scaler.firstspringapiapplication.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FakeStoreProductService implements ProductService {
    private RestTemplate restTemplate;
    FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    private Product convertFakeStoreDtoToProduct(FakeStoreProductDto dto) {
        Product product = new Product();
        product.setId(dto.getId());
        product.setTitle(dto.getTitle());
        product.setPrice(dto.getPrice());
        product.setDescription(dto.getDescription());
        product.setImage(dto.getImage());
        Category category = new Category();
        category.setDesc(dto.getCategory());
        product.setCategory(category);
        return product;
    }
    @Override
    public Product getProductById(Long id) {
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject("https://fakestoreapi.com/products/" + id,FakeStoreProductDto.class);
        if (fakeStoreProductDto == null) {
            return null;
        }
        // convert to product
        return convertFakeStoreDtoToProduct(fakeStoreProductDto);
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

}