package repository;

import java.util.HashMap;
import java.util.Map;
import model.AddressBook;

public class AddressBookRepository {
	private Map<String, AddressBook> addressBookMap = new HashMap<>();

	public void createAddressBook(String name) {
		addressBookMap.put(name, new AddressBook(name));
	}

	public AddressBook getAddressBook(String name) {
		return addressBookMap.get(name);
	}
	public Map<String, AddressBook> getAllAddressBooks() {
        return addressBookMap;
    }
}
