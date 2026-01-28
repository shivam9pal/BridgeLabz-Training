package week04.scenariobased.restaurantreservation;

public class Reservation {
	Table table;
	Customer customer;

	@Override
	public String toString() {
		return "Reservation [table=" + table + ", customer=" + customer + "]";
	}

	public Reservation(Table table,Customer customer) {
		this.customer=customer;
		this.table = table;
	}
	
}
