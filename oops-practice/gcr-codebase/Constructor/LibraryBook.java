package week02.gcrCodebase.constructor;

public class LibraryBook {
    String title;
    String author;
    double price;
    boolean available;
    //parameterized constructor
    LibraryBook(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.available = true;
    }
    //borrow
    void borrowBook() {
        if (available) {
            available = false;
            System.out.println("Book borrowed successfully");
        } else {
            System.out.println("Book not available");
        }
    }
    
    public static void main(String[] args) {
        LibraryBook b = new LibraryBook("Java", "", 500);
        b.borrowBook();
        b.borrowBook();
    }
}

