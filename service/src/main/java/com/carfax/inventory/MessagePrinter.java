package com.carfax.inventory;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carfax.inventory.Dealer;
@Service
public class MessagePrinter {
	private final DealerRepository repository;

	@Autowired
	public MessagePrinter(DealerRepository repository){
		this.repository = repository;
	}
	
	public void printAll(){
		for (Dealer message : repository.findAll()) {
			System.out.println(message.getDealershipName() +": "+ message.getUsername());
		}
	}
	
	public void printMessage(String title){
		Dealer m = repository.getDealer(title);
		System.out.println("Title: " + m.getDealershipName());
		System.out.println("Message: " + m.getUsername());
	}
}
