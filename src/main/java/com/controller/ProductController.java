package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.entity.ProductEntity;
import com.repository.ProductRepository;

@RestController
public class ProductController {

	@Autowired
	ProductRepository productrepository;
	
	@PostMapping("/product")
	public ProductEntity addproducts(@RequestBody ProductEntity productentity){
		
//		System.out.println(productentity.);
//		System.out.println(productentity.getPrice());
		productrepository.save(productentity);	
		return productentity;
	}
	
	@GetMapping("/product")
	public List<ProductEntity> getallproduct() {
		List<ProductEntity> products = productrepository.findAll();
		return products;
	}
	
	@GetMapping("/getproductbyid/{productId}")
	public ProductEntity getProductById(@PathVariable("productId") Integer productId) {
		Optional<ProductEntity> op = productrepository.findById(productId);
		if(op.isEmpty()) {
			return null;
		}else {
			ProductEntity productEntity = op.get();
			return productEntity;
		}
	}
	
	@GetMapping("/getproductbyid")
	public ProductEntity getProductById2(@RequestParam("productId") Integer productId) {
		Optional<ProductEntity> op = productrepository.findById(productId);
		if(op.isEmpty()) {
			return null;
		}else {
			ProductEntity productEntity = op.get();
			return productEntity;
		}
	}
}
