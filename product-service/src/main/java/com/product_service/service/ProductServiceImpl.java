package com.product_service.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.product_service.modal.ProductRequest;
import com.product_service.modal.ProductResponse;
import com.product_service.pojo.Product;
import com.product_service.repository.ProductRepository;

@Service
//@Slf4j
//@RequiredArgConstructor
public class ProductServiceImpl implements ProductService{
	private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

	private ProductRepository productRepository;
	
	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	@Override
	public void saveProductDetails(ProductRequest productRequest) {
		Product product = new Product(productRequest.getName(), productRequest.getDescription(), Double.parseDouble(productRequest.getPrice()));
		productRepository.save(product);
		
		logger.info("ProductServiceImpl : saveProductDetails : Product : {} is saved ", product.getId());;
	}
	
	@Override
	public ProductResponse getProductDetailsById(Long id) {
		Optional<Product> product = productRepository.findById(id);
		if(product.isPresent()) {
			return mapToProductResponse(product.get());
		}
		return null;
	}
	
	@Override
	public List<ProductResponse> getAllProductDetails() {
		List<Product> allProducts = productRepository.findAll();
		if(allProducts != null && allProducts.size() > 0) {
			return allProducts.stream().map(data -> mapToProductResponse(data)).toList(); //Function
		}
		return null;
	}
	
	public ProductResponse mapToProductResponse(Product product) {
		return new ProductResponse(product.getId(), product.getName(), product.getDescription(), String.valueOf(product.getPrice())); 
	}

}
