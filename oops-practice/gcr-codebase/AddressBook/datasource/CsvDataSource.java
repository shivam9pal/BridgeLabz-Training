package datasource;

import model.AddressBook;
import model.Person;

import java.io.*;

public class CsvDataSource implements AddressBookDataSource {

    private final String filePath;

    public CsvDataSource(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void write(AddressBook book) throws Exception {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filePath))) {
            pw.println("fname,lname,address,city,state,zip,phone,email");
            for (Person p : book.getPersons()) {
                pw.println(String.join(",",
                        p.getFname(), p.getLname(), p.getAddress(),
                        p.getCity(), p.getState(), p.getZip(),
                        p.getPhone(), p.getEmail()));
            }
        }
    }

    @Override
    public AddressBook read(String bookName) throws Exception {
        AddressBook book = new AddressBook(bookName);

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine(); // skip header
            String line;
            while ((line = br.readLine()) != null) {
                String[] a = line.split(",");
                book.getPersons().add(new Person(a[0], a[1], a[2], a[3], a[4], a[5], a[6], a[7]));
            }
        }
        return book;
    }
}
