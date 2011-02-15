package com.carfax.inventory;

import javax.xml.bind.annotation.XmlElement;

public class Product {
	@XmlElement
	private String name;

	Product(){}
	public Product(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
}
