package com.scaler.firstspringapiapplication.services;

import com.scaler.firstspringapiapplication.exceptions.ProductNotFoundException;
import com.scaler.firstspringapiapplication.models.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(Long id) throws ProductNotFoundException;
    List<Product> getAllProducts();
    Product replaceProduct(Long id, Product product);
    Product updateProduct(Long id, Product product);
    Product createProduct(Product product);
    void deleteProduct();

}
