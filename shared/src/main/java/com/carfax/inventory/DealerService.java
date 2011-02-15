package com.carfax.inventory;

import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/dealers")
@Consumes("application/json")
public interface DealerService {

	@GET
	@Path("/{name}")
	@Produces("application/json")
	Dealer getDealer(@PathParam("name") String name);

	@GET
	@Path("/")
	@Produces("application/json")
	Collection<Dealer> getDealers();

	@POST
	@Path("/")
	public void save(Dealer dealer);
}