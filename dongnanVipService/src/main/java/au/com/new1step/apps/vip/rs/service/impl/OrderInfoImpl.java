package au.com.new1step.apps.vip.rs.service.impl;

import java.util.ArrayList;
import java.util.List; 

import au.com.new1step.apps.vip.rs.model.Order;
import au.com.new1step.apps.vip.rs.model.OrderList;
import au.com.new1step.apps.vip.rs.service.OrderInfo;

public class OrderInfoImpl implements OrderInfo {  
	private List <Order> list = new ArrayList<Order>();  
	
	public OrderInfoImpl(){ 
		Order order = new Order(); 
		order.setOrderId(1); 
		order.setItemName("Soap");   
		order.setQuantity(120);    
		order.setCustomerName("Sandeep");   
		order.setShippingAddress("Gurgaon");   
		
		list.add(order); 
		
		order = new Order();
		order.setOrderId(2); 
		order.setItemName("Shampoo"); 
		order.setQuantity(50);      
		order.setCustomerName("Sandeep");
		order.setShippingAddress("Gurgaon"); 
		list.add(order);   
	}   
	
	@Override    
	public Order getOrder(int orderId) {   
		System.out.println("Inside the GetOrder..."); 
		
		for(Order order: list){
			if(order.getOrderId() == orderId){
				return order;
			}
		}
		return null;
   }  
	
	@Override  
	public OrderList getAllOrders() { 
		OrderList details = new OrderList();     
		for(Order order : list) {        
			details.getOrder().add(order); 
		}    
		return details; 
	}
}