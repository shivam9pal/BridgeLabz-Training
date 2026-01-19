package week02.addressbook;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class AddressBook {

	public static void main(String[] args) throws PersonDoesNotExistException {
		Scanner sc=new Scanner(System.in);
		
		Map<String,AddressService> addressBooks=new HashMap<>();
		AddressService addressBook=null;
		System.out.println("... Welcome To The Address Book ...");
		
		boolean flag=true;
		while(flag) {
			System.out.println("1. Create new Address Book ! ... ");
			System.out.println("2. Select the Address Book... ");
			System.out.println("3. For add New Person address ");
			System.out.println("4. To Edit the Existing addres ... ");
			System.out.println("5. To delete the Person ... ");
			System.out.println("6. To Search Person in Address Books ... ");
			System.out.println("7. To get the count of person in city ... ");
			System.out.println("8. To get the count of person in state ... ");
			System.out.println("0. to exit !!  ");
			
			int option=sc.nextInt();
			sc.nextLine();
			
			switch(option) {
			
			case 1:{
				System.out.print("Enter the name Of Address Book :");
				String name=sc.nextLine();
				if(addressBooks.containsKey(name)) {
					System.out.println("The Address Book lready Exists !!!");
				}else {
					addressBooks.put(name, new AddressService());
					System.out.println("Address Book '" + name + "' created.");
				}
				break;
			}
			
			case 2:{
				for (Map.Entry<String, AddressService> entry : addressBooks.entrySet()) {
				    System.out.println("Address Book: " + entry.getKey());
				    entry.getValue().printAddressBook();
				    System.out.println("------------------------");
				}
				System.out.print("Enter the name of Book to Select :");
				String inputBook=sc.nextLine();
				if(!addressBooks.containsKey(inputBook)) {
					System.out.println("No such address Book" + inputBook );
				}else {
					addressBook=addressBooks.get(inputBook);
					System.out.println("Selected Address Book: " + inputBook);
					
				}
				break;
			}
			
			case 3:{
				if (addressBook == null) {
				    System.out.println("Please select an Address Book first!");
				    break;
				}
				System.out.println("\nEnter the Person details as per sequence ");
				System.out.print("Enter the First Name : ");
				String firstName=sc.next();
				System.out.print("\nEnter the last Name : ");
				String lastName=sc.next();
				System.out.print("\nEnter the address : ");
				String address=sc.next();
				System.out.print("\nEnter the city : ");
				String city=sc.next();
				System.out.print("\nEnter the 6 digit Numeric ZipCode : ");
				int zipCode=sc.nextInt();
				System.out.print("\nEnter the State : ");
				String state=sc.next();
				System.out.print("\nEnter the 10 digit Contact : ");
				String contactNo=sc.next();
				System.out.print("\nEnter the Email : ");
				String email=sc.next();
				
				//making the new Person
				Person person =new Person(firstName,lastName,address,city,state,zipCode,contactNo,email);
				addressBook.addAdress(person);
				break;
				
				}
			case 4:{
				if (addressBook == null) {
				    System.out.println("Please select an Address Book first!");
				    break;
				}
				System.out.println("Enter the Person details to edit details .... ");
				System.out.print("Enter the First Name : ");
				String firstName=sc.next();
				System.out.print("Enter the Last Name : ");
				String lastName=sc.next();
				Person p =addressBook.getPersonByName(firstName,lastName);
				System.out.println(p.toString());
				System.out.println("Now Enter the name of Details to edit  ...");
				System.out.println("Enter the Sequence No of the  details you want's to edit \n 1. Address \n2. City \n3. ZipCode \n4. State \n5. Contact Number \n6. Email \n7. For all details ");	
				int input=sc.nextInt();
				sc.nextLine();
				
				switch(input) {
				
				
					case 1:{
						System.out.print("Enter the new Address :");
						String address=sc.nextLine();
						p.setAddress(address);
						System.out.print("Address updated Successfully "+p.toString());
						break;
					}
					case 2:{
						System.out.print("Enter the new city :");
						String city=sc.nextLine();
						p.setCity(city);
						System.out.print("City updated Successfully "+p.toString());
						break;
					}
					case 3:{
						System.out.print("Enter the new 6 digit ZIPCODE :");
						int zipcode=sc.nextInt();
						p.setZipCode(zipcode);
						System.out.print("ZipCode updated Successfully "+p.toString());
						break;
					}
					case 4:{
						System.out.print("Enter the new State :");
						String State=sc.nextLine();
						p.setState(State);
						System.out.print("State updated Successfully "+p.toString());
						break;
					}
					case 5:{
						System.out.print("Enter the new Contact Number :");
						String contact=sc.nextLine();
						p.setContactNo(contact);
						System.out.print("Contact updated Successfully "+p.toString());
						break;
					}
					case 6:{
						System.out.print("Enter the new Email :");
						String email=sc.nextLine();
						p.setEmail(email);
						System.out.print("Email updated Successfully "+p.toString());
						break;
					}
					case 7:{
						System.out.println("Enter the all details :");
						System.out.print("\nEnter the address : ");
						String address=sc.next();
						System.out.print("\nEnter the city : ");
						String city=sc.next();
						System.out.print("\nEnter the 6 digit Numeric ZipCode : ");
						int zipCode=sc.nextInt();
						System.out.print("\nEnter the State : ");
						String state=sc.next();
						System.out.print("\nEnter the 10 digit Contact : ");
						String contactNo=sc.next();
						System.out.print("\nEnter the Email : ");
						String email=sc.next();
						p.setAddress(address);
						p.setCity(city);
						p.setContactNo(contactNo);
						p.setEmail(email);
						p.setState(state);
						p.setZipCode(zipCode);	
						System.out.print("Address updated Successfully "+p.toString());
						break;
						}
					}
				break;
				}
			case 5:{
				if (addressBook == null) {
				    System.out.println("Please select an Address Book first!");
				    break;
				}
				System.out.println("Enter the Person Name to delete from Address Book  .... ");
				System.out.print("Enter the First Name : ");
				String firstName=sc.next();
				System.out.print("Enter the Last Name : ");
				String lastName=sc.next();
				addressBook.deleteAdress(firstName, lastName);
				break;
			}
			case 6:{
				System.out.print("\nEnter the City or state to search in Entire Address Books: ");
				String city=sc.nextLine();
				MultipileAdressBookService.searchPersonByCityOrState(addressBooks,city);
				break;
			}
			case 7:{
				System.out.print("\nEnter the City to get the Count : ");
				String city=sc.nextLine();
				MultipileAdressBookService.getCountByCity(addressBooks,city);
				break;
			}
			case 8:{
				System.out.print("\nEnter the State to get the Count : ");
				String city=sc.nextLine();
				MultipileAdressBookService.getCountByState(addressBooks,city);
				break;
			}
			
			
				
			
			
			
			case 0:
			    flag = false;
			    break;
			
			
			}
		}
		
	}
}





















