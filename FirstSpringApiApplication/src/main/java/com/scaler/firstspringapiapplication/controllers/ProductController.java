package com.scaler.firstspringapiapplication.controllers;

import com.scaler.firstspringapiapplication.commons.AuthCommons;
import com.scaler.firstspringapiapplication.dtos.UserDto;
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
    private AuthCommons authCommons;

    public ProductController(@Qualifier("selfProductService") ProductService productService,
                             AuthCommons authCommons) {
        this.productService = productService;
        this.authCommons = authCommons;
    }
    // localhost:8080/products
    @GetMapping()
    public List<Product> getAllProducts() {
        //return List.of(new Product(), new Product(), new Product());
        List<Product> actualProducts = productService.getAllProducts(); // 1234
        Product product = new Product();
        product.setId(4L);
        product.setTitle("macbook pro");
        actualProducts.add(product);
        return actualProducts;
    }

    //localhost:8080/products/1
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id ) throws ProductNotFoundException {
        //Call UserService ValidateToken API to validate the token.
        //        UserDto userDto = authCommons.validateToken(token);
        ResponseEntity<Product> responseEntity;
//        if (userDto == null) {
//            responseEntity = new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
//            return responseEntity;
//        }
        //Role Based Access.
//        for (Role role : userDto.getRoles()) {
//            if (role.getValue().equals("ADMIN")) {
//                //provide access.
//            }
//        }
        Product product = productService.getProductById(id);
        responseEntity = new ResponseEntity<>(product, HttpStatus.OK);
//        product.setTitle("Macbook Air");
////        product.setPrice(120000.0);
//        ResponseEntity<Product> responseEntity;
//        if (product == null) {
//            responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//            return responseEntity;
//        }

//        Product sampleProduct = new Product();
        return responseEntity;

//        ResponseEntity<Product> responseEntity = null;
//        try {
//            Product product = productService.getProductById(id);
//            responseEntity = new ResponseEntity<>(product, HttpStatus.OK);
//        } catch (ArithmeticException e) {
//            responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        } catch (ArrayIndexOutOfBoundsException e) {
//            responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
        //Controllers should be as light as possible.
//        return responseEntity;
        //throw new RuntimeException("Something went wrong");
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
