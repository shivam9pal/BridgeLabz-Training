package async;

import datasource.AddressBookDataSource;
import model.AddressBook;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AsyncIOService {

    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    public void saveAsync(AddressBookDataSource ds, AddressBook book) {
        executor.submit(() -> {
            try {
                ds.write(book);
                System.out.println("Async Save Completed");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
