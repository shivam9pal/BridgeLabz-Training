package datasource;

import model.AddressBook;
import model.Person;

import java.io.*;
import java.util.List;

public class FileDataSource implements AddressBookDataSource {

    private final String filePath;

    public FileDataSource(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void write(AddressBook book) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (Person p : book.getPersons()) {
                bw.write(p.getFname() + "|" + p.getLname() + "|" + p.getAddress() + "|" +
                        p.getCity() + "|" + p.getState() + "|" + p.getZip() + "|" +
                        p.getPhone() + "|" + p.getEmail());
                bw.newLine();
            }
        }
    }

    @Override
    public AddressBook read(String bookName) throws Exception {
        AddressBook book = new AddressBook(bookName);

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] arr = line.split("\\|");
                book.getPersons().add(new Person(
                        arr[0], arr[1], arr[2], arr[3], arr[4], arr[5], arr[6], arr[7]
                ));
            }
        }
        return book;
    }
}
