package week02.scenario;

class Book{
	String title;
	String author;
	//status for availability 
	String status;
	
	Book(String title, String author, String status){
		this.author=author;
		this.title=title;
		this.status=status;
	}
}

///library class
class Library{
	Book[] books;
	
	Library(Book[] book){
		this.books=book;
	}
	
	//display all books 
	void displayBook(){
		for(Book book:books) {
			System.out.println("Title : "+book.title+
								"Author : "+book.author+
								"Status : "+book.status);
		}
	}
	
	//search by partial title 
	void searchByTitle(String serTxt) {
		for(Book book:books) {
			if(book.title.toLowerCase().contains(serTxt.toLowerCase())) {
				System.out.println("Found -> Title: " + book.title + ", Author: " + book.author + ", Status: " + book.status);
			}
		}
		
	}
	
	//update book status
	void updateBookStatus(String title){
		for(Book book:books) {
			if(book.title.equalsIgnoreCase(title) && book.status.equals("Available")) {
				book.status = "Checked Out";
                System.out.println("Book Checked Out: " + book.title);
                return;
			}
		}
		
		 System.out.println("Book not available for checkout");
	}
	
}


public class LibraryManagementSystem {

	public static void main(String[] args) {
		
		Book[] bookArray = new Book[3];
        bookArray[0] = new Book("Cyber Security", "Pt HariDas", "Available");
        bookArray[1] = new Book("Spring Boot Guide", "james Gosling", "Available");
        bookArray[2] = new Book("Data Structures", "Allen turing", "Checked Out");

        Library library=new Library(bookArray);
        //testing all operations
        library.displayBook();
        library.searchByTitle("Cyber security");
        library.updateBookStatus("Spring Boot Guide");
        library.displayBook();
	}

}
