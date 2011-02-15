package com.carfax.inventory;


import java.util.Collection;

import com.carfax.inventory.Dealer;
import com.carfax.inventory.DealerService;

import javax.ws.rs.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class DefaultDealerService implements DealerService {
	private static final Logger LOG = LoggerFactory.getLogger(DealerService.class);
	private final DealerRepository dealerRepository;
	@Autowired
	public DefaultDealerService(DealerRepository repository){
		dealerRepository = repository;
	}
	public Dealer getDealer(@PathParam("title") String username){
		LOG.info("Service looking up dealer with username " + username);
		return dealerRepository.getDealer(username);
	}
	public Collection<Dealer> getDealers() {
		return dealerRepository.findAll();
	}
	public void save(Dealer message) {
		dealerRepository.save(message);
	}
}
