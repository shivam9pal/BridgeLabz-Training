package week02.addressbook;

import java.util.Map;

class MultipileAdressBookService {
	
	static void searchPersonByCityOrState(Map<String, AddressService> books, String city) {
		boolean found = false;
		

	    for (Map.Entry<String, AddressService> entry : books.entrySet()) {
	        String bookName = entry.getKey();
	        AddressService service = entry.getValue();

	        for (Person p : service.address) {   // iterate persons in each book
	            if (p.getCity().equalsIgnoreCase(city)) {
	                    System.out.println("Persons in city: " + city);
	                System.out.println("[" + bookName + "] " + p);
	                found=true;
	            }else if(p.getState().equalsIgnoreCase(city)) {
	            	System.out.println("Persons in State: " + city);
	                System.out.println("[" + bookName + "] " + p);
	                found=true;
	            }
	        }
	    }

	    if (!found) {
	        System.out.println("No persons found in city & state");
	    }
	    
		
	}
	
	static void getCountByCity(Map<String, AddressService> books, String city) {
	    int count = 0;

	    for (AddressService service : books.values()) {
	        for (Person p : service.address) {
	            if (p.getCity().equalsIgnoreCase(city)) {
	                count++;
	            }
	        }
	    }
	    System.out.println("Total persons in " + city + ": " + count);
	}

	static void getCountByState(Map<String, AddressService> books, String state) {
	    int count = 0;

	    for (AddressService service : books.values()) {
	        for (Person p : service.address) {
	            if (p.getState().equalsIgnoreCase(state)) {
	                count++;
	            }
	        }
	    }
	    System.out.println("Total persons in " + state + ": " + count);
	}

}
