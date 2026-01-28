package week04.scenariobased.restaurantreservation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class BookingUtils {
	Map<Integer, Table> tables=new HashMap<>();
	//add tables 
	public void addTables() {
		tables.put(1,new Table("Chinkychinese"));
		tables.put(2,new Table("Pinkychinese"));
		tables.put(3,new Table("Tinkychinese"));
		tables.put(4,new Table("Ponkychinese"));
		tables.put(5,new Table("SouthTaste"));
		tables.put(6,new Table("ChinkyPonky"));
	}
	
	//ArrayList for reservation
	List<Reservation> reservations=new ArrayList<>();
	
	
	//reserve Table 
	public void reserveTable(Customer c) throws TableAlreadyReservedException {
		Table table=getTable();
		reservations.add(new Reservation(table, c));
		table.setIsReserved();
		System.out.println("Table Reserved Successfully....!");
	}
	
	
	private Table getTable() throws TableAlreadyReservedException{
		for(Map.Entry<Integer, Table> entry : tables.entrySet()) {
			Integer key = entry.getKey();
		    Table table = entry.getValue();
		    if(!table.isReserved) {
		    	return table;
		    }    
	    }
		
	     throw new TableAlreadyReservedException("Table are not available.... ");
	}
		
	


	//cancel reservation
	public void CancelReservation(int userId) throws TableAlreadyReservedException {
		Reservation reservation=getReservationById(userId);
		reservations.remove(reservation);
		Table table=reservation.table;
		table.setNotReserved();
		System.out.println("Reservation Cancelled Successfully...!");
		
	}
	
	private Reservation getReservationById(int id) throws TableAlreadyReservedException {
		for(Reservation r: reservations) {
			if(r.customer.id==id) return r;
		}
		throw new TableAlreadyReservedException("Reservation Not Found By Id.... ");
	}

	//show available tables
	public void ShowAvailableTables() {
		for(Map.Entry<Integer, Table> entry : tables.entrySet()) {
			Integer key = entry.getKey();
		    Table table = entry.getValue();
		    if(!table.isReserved) {
		    	System.out.println(table.toString());
		    }    
	    }
	}
	
}




















