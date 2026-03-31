package collectors;

import java.util.*;
import java.util.stream.Collectors;

class Order {
	private String customerName;
	private double orderTotal;

	public Order(String customerName, double orderTotal) {
		this.customerName = customerName;
		this.orderTotal = orderTotal;
	}

	public String getCustomerName() {
		return customerName;
	}

	public double getOrderTotal() {
		return orderTotal;
	}
}

public class OrderSummary {

	public static void main(String[] args) {

		List<Order> orders = Arrays.asList(new Order("Rahul", 2500.50), new Order("Anita", 1800.00),
				new Order("Rahul", 3200.75), new Order("Vikram", 4100.00), new Order("Anita", 2200.25));

		Map<String, Double> totalByCustomer = orders.stream()
				.collect(Collectors.groupingBy(Order::getCustomerName, Collectors.summingDouble(Order::getOrderTotal)));

		totalByCustomer.forEach((customer, total) -> System.out.println(customer + " → Total Orders: ₹" + total));
	}
}
