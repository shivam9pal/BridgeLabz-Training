package week02.gcrCodebase.constructor;

class BookDetails {
    public String ISBN;
    protected String title;
    private String author;

    // Setter and Getter for private variable
    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }
}

// Subclass
public class EBook extends BookDetails {

    void displayBook() {
    	// public
        System.out.println("ISBN: " + ISBN);
        // protected
        System.out.println("Title: " + title);
     // private via method
        System.out.println("Author: " + getAuthor()); 
    }

    public static void main(String[] args) {
        EBook e = new EBook();
        e.ISBN = "978-12345";
        e.title = "Java Programming";
        e.setAuthor("Herbert Schildt");

        e.displayBook();
    }
}

