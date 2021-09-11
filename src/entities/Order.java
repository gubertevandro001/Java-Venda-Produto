package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import enums.OrderStatus;

public class Order {
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	
	private Date date;
	private OrderStatus orderStatus;
	private Client client;
	private List<OrderItem> orders = new ArrayList<>();
	
	
	public Order() {
	}


	public Order(Date date, OrderStatus orderStatus, Client client) {
		this.date = date;
		this.orderStatus = orderStatus;
		this.client = client;
	}
	
	public void addItem(OrderItem orderItem) {
		orders.add(orderItem);
	}
	
	public void removeItem(OrderItem orderItem) {
		orders.remove(orderItem);
	}
	
	public double total() {
		double sum = 0;
		for (OrderItem order : orders) {
			sum += order.getPrice() * order.getQuantity();
		}
		return sum;
	}

	public Date getDate() {
		return date;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ORDER SUMMARY:\n");
		sb.append("Order moment: " + sdf1.format(date) + "\n");
		sb.append("Order status: " + orderStatus + "\n");
		sb.append("Client: " + client.getNome() + " | " + sdf.format(client.getBirthDate()) + " | " + client.getEmail() + "\n");
		sb.append("Orders items:\n");
		
		for (OrderItem order : orders) {
			sb.append(order.getProduct().getName() + ", $" + order.getProduct().getPrice() + " Quantity: " + order.getQuantity() + ", Subtotal: $" + order.subTotal() + "\n");
		}
		
		sb.append("Total price: $" + total());
		return sb.toString();
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public OrderStatus getOrderStatus() {
		return orderStatus;
	}


	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	public List<OrderItem> getOrders() {
		return orders;
	}
}
