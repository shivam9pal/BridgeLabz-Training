package week02.gcrCodebase.classObject;

public class Book {
	//Setting Attributes For Book
	private String title;
    private String author;
    private double price;
    //Displaying Books detail
    void displayBookDetails() {
        System.out.println("Title of the book: " + title);
        System.out.println("Author of the book: " + author);
        System.out.println("Price of the book: " + price);
    }

    public static void main(String[] args) {
        Book b1 = new Book();
        b1.title = "A journey to Hell";
        b1.author = "Chetan Bhagat";
        b1.price = 500.0;

        Book b2 = new Book();
        b2.title = "Wings Of Fire";
        b2.author = "Abdul kalam.A.P.J";
        b2.price = 500.0;
        //Displaying the Bok details
        b1.displayBookDetails();
        b2.displayBookDetails();
    }

}
