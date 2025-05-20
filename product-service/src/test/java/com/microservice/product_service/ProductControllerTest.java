package com.microservice.product_service;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.product_service.controller.ProductController;
import com.product_service.modal.ProductRequest;
import com.product_service.modal.ProductResponse;
import com.product_service.service.ProductService;

@WebMvcTest(ProductController.class)
public class ProductControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ProductService productService;
	
	private ProductRequest productRequest;
	
	private ProductResponse productResponse;
	
	@BeforeEach
	void setUp() {
		productRequest = new ProductRequest("product-1", "Desc", "100.0");
		productResponse = new ProductResponse("product-1", "Desc", "100.0");
	}

}
