package week07.gcrcodebase.librarymanagement;

import java.util.ArrayList;
import java.util.List;

//library catalog  singleton +observer
class LibraryCatalog {
	private static LibraryCatalog instance;
	private  List<Book> books=new ArrayList<>();
	private  List<User> observers=new ArrayList<>();
	
	private LibraryCatalog () {};
	
	public static LibraryCatalog getInstance() {
		if (instance==null) {
			instance=new LibraryCatalog();
		}
		return instance;
		
	}
	
	public void addObserver(User u) {
        observers.add(u);
    }

    public void addBook(Book book) {
        books.add(book);
        notifyUsers(book.getTitle());
    }

    private void notifyUsers(String title) {
        for (User u : observers)
            u.update("New book available: " + title);
    }
	
}
