package main;

import java.util.Scanner;

import datasource.AddressBookDataSource;
import datasource.CsvDataSource;
import datasource.FileDataSource;
import datasource.JsonFileDataSource;
import model.AddressBook;
import model.Person;
import repository.AddressBookRepository;
import service.AddressBookService;
import service.AddressBookServiceImp;

public class AddressBookMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		AddressBookRepository repository = new AddressBookRepository();
		AddressBookService service = new AddressBookServiceImp(repository);

		System.out.println("Welcome to Address Book Program");

		System.out.print("Enter Address Book Name: ");
		String bookName = sc.nextLine();
		service.createAddressBook(bookName);

		while (true) {

			System.out.println("\n===== MENU =====");
			System.out.println("1. Add Contact");
			System.out.println("2. Edit Contact");
			System.out.println("3. Delete Contact");
			System.out.println("4. Exit");
			System.out.println("5. Search Person by City");
			System.out.println("6. Search Person by State");
			System.out.println("7. Count by City");
			System.out.println("8. Count by State");
			System.out.println("9. Sort by Name");
			System.out.println("10. Sort by City");
			System.out.println("11. Sort by State");
			System.out.println("12. Sort by Zip");
			System.out.println("13. Save Address Book to File (TXT)");
			System.out.println("14. Load Address Book from File (TXT)");
			System.out.println("15. Save Address Book to CSV");
			System.out.println("16. Load Address Book from CSV");
			System.out.println("17. Save Address Book to JSON");
			System.out.println("18. Load Address Book from JSON");

			System.out.print("Choose option: ");
			int choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {

			case 1:
				Person person = createPerson(sc);
				service.addPerson(bookName, person);
				break;

			case 2:
				System.out.print("Enter First Name to Edit: ");
				String editName = sc.nextLine();

				Person updatedPerson = createPerson(sc);
				boolean edited = service.editPerson(bookName, editName, updatedPerson);

				if (edited) {
					System.out.println("Contact Updated Successfully");
				} else {
					System.out.println("Contact Not Found");
				}
				break;

			case 3:
				System.out.print("Enter First Name to Delete: ");
				String deleteName = sc.nextLine();

				boolean deleted = service.deletePerson(bookName, deleteName);

				if (deleted) {
					System.out.println("Contact Deleted Successfully");
				} else {
					System.out.println("Contact Not Found");
				}
				break;

			case 4:
				System.out.println("Exiting Address Book...");
				sc.close();
				return;

			case 5:
				System.out.print("Enter City: ");
				String city = sc.nextLine();

				service.searchByCity(city).forEach(p -> System.out.println(p.getFname() + " " + p.getLname()));
				break;

			case 6:
				System.out.print("Enter State: ");
				String state = sc.nextLine();

				service.searchByState(state).forEach(p -> System.out.println(p.getFname() + " " + p.getLname()));
				break;

			case 7:
				System.out.print("Enter City: ");
				String countCity = sc.nextLine();

				System.out.println("Total Persons: " + service.countByCity(countCity));
				break;

			case 8:
				System.out.print("Enter State: ");
				String countState = sc.nextLine();

				System.out.println("Total Persons: " + service.countByState(countState));
				break;

			case 9:
				service.sortByName(bookName).forEach(p -> System.out.println(p.getFname() + " " + p.getLname()));
				break;

			case 10:
				service.sortByCity(bookName).forEach(p -> System.out.println(p.getFname() + " - " + p.getCity()));
				break;

			case 11:
				service.sortByState(bookName).forEach(p -> System.out.println(p.getFname() + " - " + p.getState()));
				break;

			case 12:
				service.sortByZip(bookName).forEach(p -> System.out.println(p.getFname() + " - " + p.getZip()));
				break;

			case 13: // UC-13 Save to File
				try {
					AddressBookDataSource fileDS = new FileDataSource("addressbook.txt");
					AddressBook book = repository.getAddressBook(bookName);
					fileDS.write(book);
					System.out.println("Address Book saved to TXT file successfully.");
				} catch (Exception e) {
					System.out.println("Error saving to file: " + e.getMessage());
				}
				break;

			case 14: // UC-13 Read from File
				try {
					AddressBookDataSource fileDS = new FileDataSource("addressbook.txt");
					AddressBook loadedBook = fileDS.read(bookName);

					// Replace in repository
					repository.getAllAddressBooks().put(bookName, loadedBook);

					System.out.println("Address Book loaded from TXT file successfully.");

					// 🔹 Print all contacts
					if (loadedBook.getPersons().isEmpty()) {
						System.out.println("Address Book is empty.");
					} else {
						System.out.println("----- Contacts in Address Book -----");
						loadedBook.getPersons().forEach(p -> {
							System.out.println("Name   : " + p.getFname() + " " + p.getLname() + "\n" + "Address: "
									+ p.getAddress() + "\n" + "City   : " + p.getCity() + "\n" + "State  : "
									+ p.getState() + "\n" + "Zip    : " + p.getZip() + "\n" + "Phone  : " + p.getPhone()
									+ "\n" + "Email  : " + p.getEmail() + "\n" + "-----------------------------------");
						});
					}
				} catch (Exception e) {
					System.out.println("Error reading from file: " + e.getMessage());
				}
				break;

			case 15: // UC-14 Save to CSV
				try {
					AddressBookDataSource csvDS = new CsvDataSource("addressbook.csv");
					AddressBook book = repository.getAddressBook(bookName);
					csvDS.write(book);
					System.out.println("Address Book saved to CSV successfully.");
				} catch (Exception e) {
					System.out.println("Error saving to CSV: " + e.getMessage());
				}
				break;

			case 16: // UC-14 Read from CSV
				try {
					AddressBookDataSource csvDS = new CsvDataSource("addressbook.csv");
					AddressBook loadedBook = csvDS.read(bookName);
					repository.getAllAddressBooks().put(bookName, loadedBook);
					System.out.println("Address Book loaded from CSV successfully.");
					if (loadedBook.getPersons().isEmpty()) {
						System.out.println("No contacts found in CSV file.");
					} else {
						System.out.println("----- Contacts in Address Book (CSV) -----");
						loadedBook.getPersons().forEach(p -> {
							System.out.println("Name   : " + p.getFname() + " " + p.getLname() + "\n" + "Address: "
									+ p.getAddress() + "\n" + "City   : " + p.getCity() + "\n" + "State  : "
									+ p.getState() + "\n" + "Zip    : " + p.getZip() + "\n" + "Phone  : " + p.getPhone()
									+ "\n" + "Email  : " + p.getEmail() + "\n"
									+ "-----------------------------------------");
						});
					}
				} catch (Exception e) {
					System.out.println("Error reading CSV: " + e.getMessage());
				}
				break;

			case 17: // UC-15 Save to JSON
				try {
					AddressBookDataSource jsonDS = new JsonFileDataSource("addressbook.json");
					AddressBook book = repository.getAddressBook(bookName);
					jsonDS.write(book);
					System.out.println("Address Book saved to JSON successfully.");
				} catch (Exception e) {
					System.out.println("Error saving JSON: " + e.getMessage());
				}
				break;

			case 18: // UC-15 Read from JSON
				try {
					AddressBookDataSource jsonDS = new JsonFileDataSource("addressbook.json");
					AddressBook loadedBook = jsonDS.read(bookName);
					repository.getAllAddressBooks().put(bookName, loadedBook);
					System.out.println("Address Book loaded from JSON successfully.");
				} catch (Exception e) {
					System.out.println("Error reading JSON: " + e.getMessage());
				}
				break;

			default:
				System.out.println("Invalid Choice. Try again.");
			}
		}
	}

	private static Person createPerson(Scanner sc) {

		System.out.print("First Name: ");
		String firstName = sc.nextLine();

		System.out.print("Last Name: ");
		String lastName = sc.nextLine();

		System.out.print("Address: ");
		String address = sc.nextLine();

		System.out.print("City: ");
		String city = sc.nextLine();

		System.out.print("State: ");
		String state = sc.nextLine();

		System.out.print("Zip: ");
		String zip = sc.nextLine();

		System.out.print("Phone: ");
		String phone = sc.nextLine();

		System.out.print("Email: ");
		String email = sc.nextLine();

		return new Person(firstName, lastName, address, city, state, zip, phone, email);

	}
}
