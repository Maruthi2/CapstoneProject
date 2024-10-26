package com.scaler.firstspringapiapplication.services;
import com.scaler.firstspringapiapplication.exceptions.ProductNotFoundException;
import com.scaler.firstspringapiapplication.models.Product;
import com.scaler.firstspringapiapplication.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("selfProductService")
//@Primary
public class SelfProductService implements ProductService {
    private ProductRepository productRepository;
    SelfProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Override
    public Product getProductById(Long id) throws ProductNotFoundException {
        //Fetch the product with the given id from DB.
        return null;
    }
    @Override
    public List<Product> getAllProducts() {
        return null;
    }
    @Override
    public Product updateProduct(Long id, Product product) {
        return null;
    }
    @Override
    public Product replaceProduct(Long id, Product product) {
        return null;
    }
    @Override
    public Product createProduct(Product product) {
        return null;
    }
    @Override
    public void deleteProduct() {
    }
}
