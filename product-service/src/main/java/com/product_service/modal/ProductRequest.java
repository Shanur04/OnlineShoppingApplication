package com.product_service.modal;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class ProductRequest {
	@NotNull
	private String name;
	@NotNull
	@NotEmpty
	private String description;
	private String price;
	
	public ProductRequest() {
		
	}
	
	public ProductRequest(String name, String description, String price) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
}
