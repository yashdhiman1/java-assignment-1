package com.npci.demo.productmanagement.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.npci.demo.productmanagement.entity.Product;

@Service
public interface ProductService {
	  Product addProduct(Product product);
	  void deleteProduct(String productId);
	    List<Product> getProducts();
	    Map<String, Object> generateBills();

}
