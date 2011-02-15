package com.carfax.inventory;


import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.carfax.inventory.Dealer;
import com.carfax.inventory.Product;

@Repository
public class MemoryDealerRepository implements DealerRepository {
	private static final Logger LOG = LoggerFactory.getLogger(MemoryDealerRepository.class);
	private final Map<String, Dealer> dealers = new ConcurrentHashMap<String, Dealer>();

	@Cacheable("message")
	public Dealer getDealer(String title){
		LOG.info("Fetching message");
		Dealer dealer = dealers.get(title);
		LOG.info("Found dealer " + dealer);
		return dealer;
	}
	@CacheEvict(value="message", key="message.title")
	public void save(Dealer dealer){
		LOG.info("Saving message");
		dealers.put(dealer.getUsername(), dealer);
	}
	public Collection<Dealer> findAll() {
		return dealers.values();
	}
	
	@PostConstruct
	public void addSomeDefaultMessages(){
		save(new Dealer("C232421", "Cripple and Creek AutoWorld"));
		save(new Dealer("C923843", "James Carrs' Cars", new Product("UPP")));
	}
}
