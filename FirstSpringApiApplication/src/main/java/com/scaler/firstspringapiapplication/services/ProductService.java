package com.scaler.firstspringapiapplication.services;

import com.scaler.firstspringapiapplication.models.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(Long id);
    List<Product> getAllProducts();
    Product replaceProduct(Long id, Product product);

}
