package service;
import java.util.List;
import model.Person;

public interface AddressBookService {
	// UC - 1
	void createAddressBook(String name);
	
	// UC - 2
	void addPerson(String bookNae, Person person);
	
	// UC - 3
	boolean editPerson(String bookName, String firstName, Person updatedPerson);
	
	// UC - 4
	boolean deletePerson(String bookName, String firstName);
	
	List<Person> searchByCity(String city);

    List<Person> searchByState(String state);
    
    long countByCity(String city);

    long countByState(String state);
    
    // UC-11
    List<Person> sortByName(String bookName);

    // UC-12
    List<Person> sortByCity(String bookName);
    List<Person> sortByState(String bookName);
    List<Person> sortByZip(String bookName);
}
