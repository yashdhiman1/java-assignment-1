package com.npci.demo.productmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.npci.demo.productmanagement.entity.Product;
import com.npci.demo.productmanagement.service.ProductService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/addProduct")
    public ResponseEntity<String> addProduct(@RequestBody Product product) {
        productService.addProduct(product);
        return ResponseEntity.status(HttpStatus.OK).body("Product added successfully");
    }

    @GetMapping("/listProducts")
    public ResponseEntity<List<Product>> findAllProducts() {
        List<Product> products = productService.getProducts();
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }

    @GetMapping("/checkout")
    public ResponseEntity<Map<String, Object>> checkout() {
        Map<String, Object> billDetails = productService.generateBills();
        return ResponseEntity.status(HttpStatus.OK).body(billDetails);
    }
    
    @DeleteMapping("/deleteProduct/{productId}")
    public ResponseEntity<String> deleteProduct(@PathVariable String productId) {
        productService.deleteProduct(productId);
        return ResponseEntity.status(HttpStatus.OK).body("Product deleted successfully");
    }
}
