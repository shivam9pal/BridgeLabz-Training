package week04.scenariobased.restaurantreservation;

class TableBooking {

	public static void main(String[] args) {
		Customer c1=new Customer(1, "Shivam");
		Customer c2=new Customer(2, "Himasnhu");
		Customer c3=new Customer(3, "Sumit");
		Customer c4=new Customer(4, "Ravi");
		
		
		BookingUtils reception=new BookingUtils();
		try {
			//add tables 
			reception.addTables();
			
			//reserve Table
			reception.reserveTable(c4);
			
			
			//cancel reservation 
			reception.CancelReservation(4);
			
			
			//show all tables
			reception.ShowAvailableTables();
			
			//
			reception.reserveTable(c1);
			
			//show all tables
			reception.ShowAvailableTables();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		
	}
}
