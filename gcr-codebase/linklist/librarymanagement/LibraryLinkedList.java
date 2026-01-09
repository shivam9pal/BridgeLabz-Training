package week3dsa.linkedlist.librarymanagement;

public class LibraryLinkedList {
    
    private Book head;
    private Book tail;
    
    public LibraryLinkedList() {
        this.head = null;
        this.tail = null;
    }
    
    // Add book at beginning
    public void addAtBeginning(int bookId, String title, String author, String genre, boolean isAvailable) {
        Book newBook = new Book(bookId, title, author, genre, isAvailable);
        
        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
        System.out.println("✓ Added at beginning: " + title);
    }
    
    // Add book at end
    public void addAtEnd(int bookId, String title, String author, String genre, boolean isAvailable) {
        Book newBook = new Book(bookId, title, author, genre, isAvailable);
        
        if (tail == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
        System.out.println("✓ Added at end: " + title);
    }
    
    // Add at position
    public void addAtPosition(int bookId, String title, String author, String genre, boolean isAvailable, int position) {
        if (position < 1) {
            System.out.println("✗ Position must be >= 1");
            return;
        }
        
        if (position == 1) {
            addAtBeginning(bookId, title, author, genre, isAvailable);
            return;
        }
        
        Book newBook = new Book(bookId, title, author, genre, isAvailable);
        Book temp = head;
        int count = 1;
        
        while (count < position - 1 && temp != null) {
            temp = temp.next;
            count++;
        }
        
        if (temp == null) {
            System.out.println("✗ Position out of bounds!");
            return;
        }
        
        newBook.next = temp.next;
        newBook.prev = temp;
        
        if (temp.next != null) {
            temp.next.prev = newBook;
        } else {
            tail = newBook;
        }
        
        temp.next = newBook;
        System.out.println("✓ Added at position " + position + ": " + title);
    }
    
    // Remove by book ID
    public void removeById(int bookId) {
        if (head == null) {
            System.out.println("✗ List is empty!");
            return;
        }
        
        Book temp = head;
        
        while (temp != null && temp.bookId != bookId) {
            temp = temp.next;
        }
        
        if (temp == null) {
            System.out.println("✗ Book not found with ID: " + bookId);
            return;
        }
        
        if (temp.prev != null) {
            temp.prev.next = temp.next;
        } else {
            head = temp.next;
        }
        
        if (temp.next != null) {
            temp.next.prev = temp.prev;
        } else {
            tail = temp.prev;
        }
        
        System.out.println("✓ Removed book ID: " + bookId);
    }
    
    // Search by title
    public void searchByTitle(String title) {
        if (head == null) {
            System.out.println("✗ List is empty!");
            return;
        }
        
        Book temp = head;
        boolean found = false;
        System.out.println("\nBooks matching title '" + title + "':");
        
        while (temp != null) {
            if (temp.title.toLowerCase().contains(title.toLowerCase())) {
                System.out.println("  " + temp);
                found = true;
            }
            temp = temp.next;
        }
        
        if (!found) {
            System.out.println("  No books found");
        }
    }
    
    // Search by author
    public void searchByAuthor(String author) {
        if (head == null) {
            System.out.println("✗ List is empty!");
            return;
        }
        
        Book temp = head;
        boolean found = false;
        System.out.println("\nBooks by " + author + ":");
        
        while (temp != null) {
            if (temp.author.toLowerCase().contains(author.toLowerCase())) {
                System.out.println("  " + temp);
                found = true;
            }
            temp = temp.next;
        }
        
        if (!found) {
            System.out.println("  No books found");
        }
    }
    
    // Update availability
    public void updateAvailability(int bookId, boolean isAvailable) {
        Book temp = head;
        
        while (temp != null && temp.bookId != bookId) {
            temp = temp.next;
        }
        
        if (temp != null) {
            temp.isAvailable = isAvailable;
            System.out.println("✓ Updated availability for ID " + bookId + " to " + (isAvailable ? "Available" : "Not Available"));
        } else {
            System.out.println("✗ Book not found with ID: " + bookId);
        }
    }
    
    // Count total books
    public void countBooks() {
        int count = 0;
        Book temp = head;
        
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        
        System.out.println("Total books in library: " + count);
    }
    
    // Display forward
    public void displayForward() {
        if (head == null) {
            System.out.println("✗ No books in the library.");
            return;
        }
        
        System.out.println("\n=== Books (Forward) ===");
        Book temp = head;
        int position = 1;
        
        while (temp != null) {
            System.out.println(position + ". " + temp);
            temp = temp.next;
            position++;
        }
        System.out.println("=======================\n");
    }
    
    // Display reverse
    public void displayReverse() {
        if (tail == null) {
            System.out.println("✗ No books in the library.");
            return;
        }
        
        System.out.println("\n=== Books (Reverse) ===");
        Book temp = tail;
        int position = 1;
        
        while (temp != null) {
            System.out.println(position + ". " + temp);
            temp = temp.prev;
            position++;
        }
        System.out.println("=======================\n");
    }
}
