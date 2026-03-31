package week3dsa.linkedlist.librarymanagement;

// Node class for doubly linked list
class Book {
    int bookId;
    String title;
    String author;
    String genre;
    boolean isAvailable;
    
    Book next;
    Book prev;
    
    public Book(int bookId, String title, String author, String genre, boolean isAvailable) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isAvailable = isAvailable;
        this.next = null;
        this.prev = null;
    }
    
    @Override
    public String toString() {
        return String.format("ID: %d | Title: %s | Author: %s | Genre: %s | Available: %s", 
                            bookId, title, author, genre, isAvailable ? "Yes" : "No");
    }
}
