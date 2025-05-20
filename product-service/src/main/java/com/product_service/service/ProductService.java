package com.product_service.service;

import java.util.List;

import com.product_service.modal.ProductRequest;
import com.product_service.modal.ProductResponse;

public interface ProductService {
	void saveProductDetails(ProductRequest productRequest);
	
	ProductResponse getProductDetailsById(Long id);

	List<ProductResponse> getAllProductDetails();
}
