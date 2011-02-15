package com.carfax.inventory;

import java.util.Collection;

import com.carfax.inventory.Dealer;
public interface DealerRepository {

	Dealer getDealer(String title);

	void save(Dealer message);

	Collection<Dealer> findAll();

}