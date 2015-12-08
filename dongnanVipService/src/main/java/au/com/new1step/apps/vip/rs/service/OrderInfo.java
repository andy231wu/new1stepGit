package au.com.new1step.apps.vip.rs.service;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces; 

import au.com.new1step.apps.vip.rs.model.Order;
import au.com.new1step.apps.vip.rs.model.OrderList;

@Path("/Order/")
public interface OrderInfo {
	@GET
	@Produces ("application/json")
	//@Produces ("application/xml")
	@Path("{orderId}")
	public Order getOrder(@PathParam ("orderId") int officeId); 
	
	@GET
	@Produces ("application/xml")
	@Path ("All")
	public OrderList getAllOrders(); 
}