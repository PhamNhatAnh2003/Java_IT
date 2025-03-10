package com.demo.repository;

	import java.util.List;
	import com.demo.model.OrderItem;

	public interface OrderItemRepository {
	    List<OrderItem> getAllOrderItems();

	    List<OrderItem> getOrderItemsByOrderListId(int orderListId);
	}


