package week02.gcrcodebase.staticfinal;

class Book {
	// static variable
    static String libraryName = "Central Library"; 
    String title;
    String author;
 // final variable
    final String ISBN; 

    // Constructor
    Book(String title, String author, String ISBN) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
    }

    // Static method
    static void displayLibraryName() {
        System.out.println("Library Name: " + libraryName);
    }

    // Instance method
    public void displayBookDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + ISBN);
    }
}

public class LibraryMangSystem extends Book {

    LibraryMangSystem(String title, String author, String ISBN) {
        super(title, author, ISBN);
    }

    public static void main(String[] args) {
        LibraryMangSystem libMangSys =
                new LibraryMangSystem("Effective Java", "Joshua Bloch", "978-0134685991");
        // static method call
        Book.displayLibraryName();
     // instance method call
        libMangSys.displayBookDetails(); 
    }
}
