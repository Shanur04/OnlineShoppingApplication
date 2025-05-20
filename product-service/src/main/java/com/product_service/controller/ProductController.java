package com.product_service.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.product_service.modal.ProductRequest;
import com.product_service.modal.ProductResponse;
import com.product_service.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/product")
public class ProductController {

	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	private ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	//@PostMapping(value = "/save", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED) //Status Code : 201
	public void createProduct(@RequestBody  @Valid ProductRequest productRequest) {
		logger.info("ProductController : createProduct() : Inside method");
		productService.saveProductDetails(productRequest);
		logger.info("ProductController : createProduct() : return success");
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<ProductResponse>> getAllProductDetails() {
		List<ProductResponse> productInDB = productService.getAllProductDetails();
		if(productInDB == null) {
			logger.error("ProductController : getAllProductDetails() : Product list is null");
			return new ResponseEntity<>(HttpStatus.NO_CONTENT); //404
		}
		logger.error("ProductController : getAllProductDetails() : Size of Product list is : "+productInDB.size());
		return new ResponseEntity<>(productInDB, HttpStatus.OK); //200
	}
	
	@GetMapping("/fetch/{id}")
	public ResponseEntity<ProductResponse> getProductDetails(@PathVariable Long id) {
		ProductResponse productInDB = productService.getProductDetailsById(id);
		if(productInDB == null) {
			logger.error("ProductController : getAllProductDetails() : ");
			return new ResponseEntity<ProductResponse>(HttpStatus.NOT_FOUND); //404
		}
		logger.error("ProductController : getAllProductDetails() : Data is present with Product Id : "+productInDB.getId());
		return new ResponseEntity<ProductResponse>(productInDB, HttpStatus.OK); //200
	}
}
