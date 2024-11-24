package com.scaler.firstspringapiapplication.controllers;
import com.scaler.firstspringapiapplication.exceptions.ProductNotFoundException;
import com.scaler.firstspringapiapplication.models.Product;
import com.scaler.firstspringapiapplication.services.ProductService;
import jdk.jfr.Percentage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductControllerTest {
    @Autowired
    private ProductController productController;

    @MockBean // THis is going to be Mocked Object.
    private ProductService productService;

    @Test
    void testValidGetProductById() throws ProductNotFoundException {
        Product product = new Product();
        product.setId(1L);
        product.setTitle("Macbook pro");
        product.setPrice(150000.0);

        when(productService.getProductById(1L))
                .thenReturn(product);

//        ResponseEntity<Product> responseEntity = productController.getProductById(1L);
//        Product actualProduct = responseEntity.getBody();

//        assertEquals(product, actualProduct);

//        assertSame();
    }

    //TODO
    @Test
    void testInValidGetProductById() {
        //If the productId passed  in the input doesn't exist in the DB then let's say we are
        //throwing an Exception, we need to write a TC to test that Exception.


        //assertThrows(ProductNotFoundException.class, () -> productController.getProductById(100L));
    }

    @Test
    void testGetAllProducts() {
        List<Product> expectedProducts = new ArrayList<>(); // 1234
        Product p1 = new Product();
        p1.setId(1L);
        p1.setTitle("iPhone 13 pro");

        Product p2 = new Product();
        p2.setId(2L);
        p2.setTitle("iPhone 14 pro");

        Product p3 = new Product();
        p3.setId(3L);
        p3.setTitle("iPhone 15 pro");

        expectedProducts.add(p1);
        expectedProducts.add(p2);
        expectedProducts.add(p3);

        when(productService.getAllProducts())
                .thenReturn(expectedProducts);

        List<Product> products = productController.getAllProducts();

//        if (expectedProducts.size() == products.size()) {
//            for (int i = 0; i < expectedProducts.size(); i++) {
//                products[i] compare with expectedProducts[i];
//            }
//        }

        assertIterableEquals(expectedProducts, products);
    }

}