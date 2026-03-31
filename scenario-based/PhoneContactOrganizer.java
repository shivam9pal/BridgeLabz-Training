package week02.scenario;

import java.util.ArrayList;
import java.util.List;

class InvalidPhoneNumberException extends Exception{
	InvalidPhoneNumberException(String message){
		super(message);
	}
}

class Contact {

	// String to preserve leading zeros
    private String name;
    private String phoneNumber; 
    Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
    public String getName() {
        return name;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
}

class ContactManager{
		
	//validate Phone numebr
	private static void validatePhoneNumber(String number) {
		try{if(number.length()!=10) {
			throw new InvalidPhoneNumberException(
					"Invlaid Phone Number : "+number+"Must be of 10 digit"
					);
			}
		}catch(InvalidPhoneNumberException e) {}
	}
	
	
	//check duplicates 
	private static boolean isDuplicate(List<Contact> contact,String number) {
		for(Contact c:contact) {
			if(c.getPhoneNumber().equals(number)) {
				return true;
			}
		}
		return false;
	}
	
	
	
	//add contact
	public static void addContact(List<Contact> contactList,String name,String phoneNumber) throws InvalidPhoneNumberException{
		
		//validate
		validatePhoneNumber(phoneNumber);
		
		//check Duplicacy
		if(isDuplicate(contactList,phoneNumber)) {
			System.out.println("Contact already exists with phone number: " + phoneNumber);
            return;
		}
		
		//now add to list of contact
		contactList.add(new Contact(name,phoneNumber));
		System.out.println("Contact added successfully.");
	}
	
	//delete contact
	public static void deleteContact(List<Contact> contactList,String phoneNumber) {
		for(Contact c:contactList) {
			if(c.getPhoneNumber().equals(phoneNumber)){
				contactList.remove(c);
				System.out.println("Contact deleted .");
				return ;
			}
			
		}
		System.out.println("Contact not found.");
	}
	
	
	public static void searchContact(List<Contact> contactList,String phoneNumber){
		for (Contact c : contactList) {
            if (c.getPhoneNumber().equals(phoneNumber)) {
                System.out.println("Contact Found:");
                System.out.println("Name : " + c.getName());
                System.out.println("Phone: " + c.getPhoneNumber());
                return;
            }
	
		}
		System.out.println("Contact not found.");
	}
	
}
	


public class PhoneContactOrganizer {
	public static void main(String[] args) {
	//creating list for contacts
		List<Contact> contactList = new ArrayList<>();

        try {
            ContactManager.addContact(contactList, "Himanshu", "8218880847");
            ContactManager.addContact(contactList, "Rahul", "9876543210");

            // duplicate test
            ContactManager.addContact(contactList, "Amit", "8218880847");

            // invalid number test
            ContactManager.addContact(contactList, "Rohit", "12345");

        } catch (InvalidPhoneNumberException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        // search
        ContactManager.searchContact(contactList, "9876543210");

        // delete
        ContactManager.deleteContact(contactList, "8218880847");

        // search after delete
        ContactManager.searchContact(contactList, "8218880847");
	}
}
	
