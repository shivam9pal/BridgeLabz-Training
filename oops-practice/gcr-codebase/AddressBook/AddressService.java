package week02.addressbook;

import java.util.ArrayList;
import java.util.List;

class AddressService {
	
//	//making the collection of addressBook
//	List<> address=new ArrayList<>();
	
	//saving the person in a list 
	List<Person> address=new ArrayList<>();

	
	//add a person to Address Book
	 void addAdress(Person person){
		//first need to check is person already exists
		 boolean check=isPersonExist(person);
		 if(check) {
			 System.out.println("The Person is Already exist , so cannot add !");
			 return;
		 }
		 address.add(person);
		 System.out.println("Person added successfully");
	}
	 
	//delete a person to Address Book
	void deleteAdress(String firstName,String lastName)throws PersonDoesNotExistException{
		Person person =getPersonByName(firstName,lastName);
		address.remove(person);
		System.out.println("The Person is removed from Address Book");
		printAddressBook();	
	}
		 
	//edit a person to Address Book using name
	void editAdress(String firstName,String lastName) throws PersonDoesNotExistException{
		// get perosn by name
		Person person=getPersonByName(firstName,lastName);
		
	}
	
	//add a person to Address Book
	void addAdresss(Person person){
			
	}
	
	//dose person exists
	boolean isPersonExist(Person person) {
		if(address.contains(person)) {
			return true;
		}
		return false;
		
	}
	
	//get Person by first and lastname
	Person getPersonByName(String first,String last) throws PersonDoesNotExistException  {
		if(address.size()<=0) {
			throw new PersonDoesNotExistException("The Address Book is Empty");
		}
		for(Person p:address) {
			if(p.getFirstName().equalsIgnoreCase(first) && p.getLastName().equalsIgnoreCase(last)) {
				return p;
			}
		}
		throw new PersonDoesNotExistException("Person Not found :"+first +" "+last);
	}
	
	//get persons by city
	List<Person> getPersonByCity(String city){
		List<Person> persons=new ArrayList<>();
		for(Person p:address) {
			if(p.getCity().equalsIgnoreCase(city)) {
				persons.add(p);
			}
		}
		return persons;
		
	}
		
	// print the addressBoook
	void printAddressBook(){
		address.stream().forEachOrdered(System.out::println);
		
	}
	 
}






















