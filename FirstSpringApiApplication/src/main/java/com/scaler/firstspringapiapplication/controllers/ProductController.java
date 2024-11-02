package com.scaler.firstspringapiapplication.controllers;

import com.scaler.firstspringapiapplication.exceptions.ProductNotFoundException;
import com.scaler.firstspringapiapplication.models.Product;
import com.scaler.firstspringapiapplication.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;
    public ProductController(@Qualifier("selfProductService") ProductService productService) {
        this.productService = productService;
    }
    @GetMapping()
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) throws ProductNotFoundException {
        Product product = productService.getProductById(id);
        ResponseEntity<Product> responseEntity;
//        if (product == null) {
//            responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//            return responseEntity;
//        }

//        responseEntity = new ResponseEntity<>(product, HttpStatus.OK);
////        return responseEntity;

//        ResponseEntity<Product> responseEntity = null;
//        try {
//            Product product = productService.getProductById(id);
//            responseEntity = new ResponseEntity<>(product, HttpStatus.OK);
//        } catch (ArithmeticException e){
//            responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        } catch (ArrayIndexOutOfBoundsException e){
//            responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
        // Above approach is not recommended because controller should be as light as possible
        //or
//        throw new RuntimeException("Something went wrong");
        responseEntity = new ResponseEntity<>(product, HttpStatus.OK);
        return responseEntity;
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        return productService.replaceProduct(id, product);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) { // can use DTO as well.
        return productService.createProduct(product);
    }
}
