package week07.gcrcodebase.librarymanagement;




public class LibraryApp {
    public static void main(String[] args) {
        LibraryCatalog catalog = LibraryCatalog.getInstance();

        User s1 = UserFactory.createUser("student", "Alice");
        User f1 = UserFactory.createUser("faculty", "Dr. Bob");

        catalog.addObserver(s1);
        catalog.addObserver(f1);

        Book book = new Book.BookBuilder("Design Patterns")
                .author("GoF")
                .edition("2nd")
                .genre("SE")
                .build();

        catalog.addBook(book);
    }
}

