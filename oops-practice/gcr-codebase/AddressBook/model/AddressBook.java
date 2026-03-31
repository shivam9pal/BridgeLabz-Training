package model;

import java.util.*;


public class AddressBook {
	private String name;
	private List<Person> persons;

	public AddressBook(String name) {
		this.name = name;
		this.persons = new ArrayList<>();
	}

	public List<Person> getPersons() {
		return persons;
	}
}
