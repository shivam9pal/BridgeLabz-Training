package week02.gcrCodebase.constructor;

public class Book {
    String title;
    String author;
    double price;
    //default constructor
    Book() {
        title = "Java Basics";
        author = "James Gosling";
        price = 499.0;
    }
    //parameterized constructor
    Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    void display() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
    }

    public static void main(String[] args) {
    	//making object
        Book b1 = new Book();
        Book b2 = new Book("OOP Java", "henry Ford", 650);
        b1.display();
        System.out.println();
        b2.display();
    }
}

