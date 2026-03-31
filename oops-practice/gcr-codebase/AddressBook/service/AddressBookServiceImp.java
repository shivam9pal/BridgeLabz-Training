package service;


import java.util.ArrayList;
import java.util.List;
import model.AddressBook;
import model.Person;
import repository.AddressBookRepository;
import java.util.Comparator;

public class AddressBookServiceImp implements AddressBookService {

    private AddressBookRepository repository;

    public AddressBookServiceImp(AddressBookRepository repository) {
        this.repository = repository;
    }

    @Override
    public void createAddressBook(String name) {
        repository.createAddressBook(name);
    }

    @Override // UC - 7 will not allow duplicate entries
    public void addPerson(String bookName, Person person) {

        AddressBook book = repository.getAddressBook(bookName);

        boolean exists = book.getPersons().stream()
                .anyMatch(p ->
                        p.getFname().equalsIgnoreCase(
                                person.getFname()));

        if (exists) {
            System.out.println("Duplicate Entry Not Allowed");
            return;
        }

        book.getPersons().add(person);
    }

    @Override
    public boolean editPerson(String bookName, String firstName, Person updatedPerson) {

        AddressBook book = repository.getAddressBook(bookName);

        for (Person person : book.getPersons()) {
            if (person.getFname().equalsIgnoreCase(firstName)) {

                person.setLname(updatedPerson.getLname());
                person.setAddress(updatedPerson.getAddress());
                person.setCity(updatedPerson.getCity());
                person.setState(updatedPerson.getState());
                person.setZip(updatedPerson.getZip());
                person.setPhone(updatedPerson.getPhone());
                person.setEmail(updatedPerson.getEmail());

                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deletePerson(String bookName, String firstName) {

        AddressBook book = repository.getAddressBook(bookName);

        return book.getPersons()
                .removeIf(p -> p.getFname().equalsIgnoreCase(firstName));
    }
    @Override
    public List<Person> searchByCity(String city) {

        List<Person> result = new ArrayList<>();

        for (AddressBook book : repository.getAllAddressBooks().values()) {
            for (Person person : book.getPersons()) {
                if (person.getCity().equalsIgnoreCase(city)) {
                    result.add(person);
                }
            }
        }
        return result;
    }

    @Override
    public List<Person> searchByState(String state) {

        List<Person> result = new ArrayList<>();

        for (AddressBook book : repository.getAllAddressBooks().values()) {
            for (Person person : book.getPersons()) {
                if (person.getState().equalsIgnoreCase(state)) {
                    result.add(person);
                }
            }
        }
        return result;
    }
    
    @Override
    public long countByCity(String city) {
        return searchByCity(city).size();
    }

    @Override
    public long countByState(String state) {
        return searchByState(state).size();
    }
    
    @Override
    public List<Person> sortByName(String bookName) {

        List<Person> persons =
                repository.getAddressBook(bookName).getPersons();

        persons.sort(Comparator.comparing(Person::getFname,
                String.CASE_INSENSITIVE_ORDER));

        return persons;
    }

    @Override
    public List<Person> sortByCity(String bookName) {

        List<Person> persons =
                repository.getAddressBook(bookName).getPersons();

        persons.sort(Comparator.comparing(Person::getCity,
                String.CASE_INSENSITIVE_ORDER));

        return persons;
    }

    @Override
    public List<Person> sortByState(String bookName) {

        List<Person> persons =
                repository.getAddressBook(bookName).getPersons();

        persons.sort(Comparator.comparing(Person::getState,
                String.CASE_INSENSITIVE_ORDER));

        return persons;
    }

    @Override
    public List<Person> sortByZip(String bookName) {

        List<Person> persons =
                repository.getAddressBook(bookName).getPersons();

        persons.sort(Comparator.comparing(Person::getZip));

        return persons;
    }

}
