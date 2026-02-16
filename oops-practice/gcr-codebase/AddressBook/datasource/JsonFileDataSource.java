package datasource;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.AddressBook;

import java.io.File;

public class JsonFileDataSource implements AddressBookDataSource {

    private final File file;
    private final ObjectMapper mapper = new ObjectMapper();

    public JsonFileDataSource(String path) {
        this.file = new File(path);
    }

    @Override
    public void write(AddressBook book) throws Exception {
        mapper.writerWithDefaultPrettyPrinter().writeValue(file, book);
    }

    @Override
    public AddressBook read(String bookName) throws Exception {
        return mapper.readValue(file, AddressBook.class);
    }
}
