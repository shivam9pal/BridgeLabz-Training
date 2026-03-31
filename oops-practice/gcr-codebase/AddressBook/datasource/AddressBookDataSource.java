package datasource;

import model.AddressBook;

public interface AddressBookDataSource {
    void write(AddressBook book) throws Exception;
    AddressBook read(String bookName) throws Exception;
}
