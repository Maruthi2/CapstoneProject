package com.scaler.firstspringapiapplication.services;
import com.scaler.firstspringapiapplication.exceptions.ProductNotFoundException;
import com.scaler.firstspringapiapplication.models.Category;
import com.scaler.firstspringapiapplication.models.Product;
import com.scaler.firstspringapiapplication.repositories.CategoryRepository;
import com.scaler.firstspringapiapplication.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")
@Primary
public class SelfProductService implements ProductService {
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    SelfProductService(ProductRepository productRepository,
                       CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }
    @Override
    public Product getProductById(Long id) throws ProductNotFoundException {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isEmpty()) {
            throw new ProductNotFoundException(id, "Product not found");
        }
        return optionalProduct.get();
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
        //Before saving the Product object in the DB, save the category object.
        Category category = product.getCategory();
        if (category.getId() == null) {
            //we need to save the category
//            Category savedCategory = categoryRepository.save(category);
//            product.setCategory(savedCategory);
        } else {
            //we should check if the category id is valid or not.
        }
        Product savedProduct =  productRepository.save(product);
        Optional<Category> optionalCategory = categoryRepository.findById(savedProduct.getCategory().getId());
        Category category1 = optionalCategory.get();
        savedProduct.setCategory(category1);
        return savedProduct;

    }
    @Override
    public void deleteProduct() {
    }
}
