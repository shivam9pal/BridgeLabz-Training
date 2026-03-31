package week02.gcrcodebase.abstractinterface;

import java.util.ArrayList;
import java.util.List;

interface Reservable {
    void reserveItem(String borrowerName);
    boolean checkAvailability();
}

abstract class LibraryItem {

    private String itemId;
    private String title;
    private String author;

    // sensitive borrower info 
    private String borrowerName;
    private boolean available = true;

    // constructor
    LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    // getters (encapsulation)
    public String getItemId() {
        return itemId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    protected void setBorrower(String borrowerName) {
        this.borrowerName = borrowerName;
        this.available = false;
    }

    protected void clearBorrower() {
        this.borrowerName = null;
        this.available = true;
    }

    public boolean isAvailable() {
        return available;
    }

    // abstract method
    public abstract int getLoanDuration();

    // concrete method
    public void getItemDetails() {
        System.out.printf("Item ID   : %s%n", itemId);
        System.out.printf("Title     : %s%n", title);
        System.out.printf("Author    : %s%n", author);
        System.out.printf("Available : %s%n", available ? "Yes" : "No");
    }
}

class Book extends LibraryItem implements Reservable {

    Book(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 14; 
    }

    @Override
    public void reserveItem(String borrowerName) {
        if (isAvailable()) {
            setBorrower(borrowerName);
            System.out.println("Book reserved successfully.");
        } else {
            System.out.println("Book is already reserved.");
        }
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable();
    }
}

class Magazine extends LibraryItem implements Reservable {

    Magazine(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 7; 
    }

    @Override
    public void reserveItem(String borrowerName) {
        if (isAvailable()) {
            setBorrower(borrowerName);
            System.out.println("Magazine reserved successfully.");
        } else {
            System.out.println("Magazine is already reserved.");
        }
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable();
    }
}

class DVD extends LibraryItem implements Reservable {

    DVD(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 3; 
    }

    @Override
    public void reserveItem(String borrowerName) {
        if (isAvailable()) {
            setBorrower(borrowerName);
            System.out.println("DVD reserved successfully.");
        } else {
            System.out.println("DVD is already reserved.");
        }
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable();
    }
}

public class LibraryManagementSystem {

	public static void main(String[] args) {
		List<LibraryItem> items = new ArrayList<>();

        LibraryItem b1 = new Book("B101", "Java Programming", "James Gosling");
        LibraryItem m1 = new Magazine("M202", "Tech Monthly", "Editorial Team");
        LibraryItem d1 = new DVD("D303", "Inception", "Christopher Nolan");

        items.add(b1);
        items.add(m1);
        items.add(d1);

        for (LibraryItem item : items) {

            item.getItemDetails();
            System.out.println("Loan Duration : "
                    + item.getLoanDuration() + " days");

            if (item instanceof Reservable) {
                Reservable r = (Reservable) item;

                if (r.checkAvailability()) {
                    r.reserveItem("Shivam");
                }
            }

            System.out.println("");
        }

	}

}
