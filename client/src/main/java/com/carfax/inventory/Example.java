package com.carfax.inventory;

import org.jboss.resteasy.client.ProxyFactory;

public class Example {
	public static void main(String[] args) {
		DealerService service = ProxyFactory.create(DealerService.class, "http://localhost:8080/service");
		
		System.out.println(service.getDealer("C923843").getDealershipName());
		System.out.println(service.getDealer("C923843").getDealershipName());
		
		for (Dealer dealer : service.getDealers()) {
			System.out.println(dealer.getUsername() + " : " + dealer.getDealershipName());
		}
		
		// create a dealer
		Dealer d = new Dealer("C19029", "Pawal's Cars");
		service.save(d);
		for (Dealer dealer : service.getDealers()) {
			System.out.println(dealer.getUsername() + " : " + dealer.getDealershipName());
		}
	}
}
