package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner (System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter cliente data:");
		System.out.println("Name: ");
		String name = sc.next();
		sc.nextLine();
		System.out.println("Email: ");
		String email = sc.next();
		System.out.println("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.next());
		
		Client client = new Client(name, email, birthDate);
		
		System.out.println("Enter order data: ");
		System.out.println("Status: ");
		String status = sc.next();
		
		Order order = new Order(new Date(), OrderStatus.valueOf(status), client);
		
		System.out.println("How many items to this order?: ");
		Integer totalItems = sc.nextInt();
		
		for (int n = 0; n < totalItems; n ++) {
			System.out.println("Product name: ");
			String nameProduct = sc.next();
			System.out.println("Product price: ");
			Double productPrice = sc.nextDouble();
			System.out.println("Quantity: ");
			Integer quantity = sc.nextInt();
			
			OrderItem orderItem = new OrderItem(quantity, productPrice, new Product(nameProduct, productPrice));
			order.addItem(orderItem);
			
			}
		
		System.out.println(order);
	}

}
