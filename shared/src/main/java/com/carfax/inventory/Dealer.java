package com.carfax.inventory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Dealer implements Serializable{
	@XmlElement 
	private int id;
	@XmlElement
	private String username;
	@XmlElement
	private String dealershipName;
	@XmlElement 
	private final List<Product> products = new ArrayList<Product>();
	Dealer(){}
	public Dealer(String username, String dealerName, Product... products) {
		this.username = username;
		this.dealershipName = dealerName;
		this.products.addAll(Arrays.asList(products));
	}
	public String getUsername() {
		return username;
	}
	
	public String getDealershipName() {
		return dealershipName;
	}
	public boolean hasProduct(String name){
		// lame loop
		for (Product product : this.products) {
			if(product.getName().equals(name)){
				return true;
			}
		}
		return false;
	}
}
