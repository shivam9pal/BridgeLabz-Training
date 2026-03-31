package week07.gcrcodebase.librarymanagement;

public class Book {
    private String title, author, edition, genre;

    private Book(BookBuilder b) {
        title = b.title;
        author = b.author;
        edition = b.edition;
        genre = b.genre;
    }

    public String getTitle() { return title; }
    
    
    public static class BookBuilder{
    	private String title;
    	private String author;
    	private String edition;
    	private String genre;
    	
    	
    	public BookBuilder(String title) {
    		this.title=title;
    	}
    	public BookBuilder author(String a) {
    		
    		author=a;
    		return this;
    		}
    	
    	public BookBuilder edition(String a) {
    		
    		edition=a;
    		return this;
    		}
    	
    	public BookBuilder genre(String a) {
	
			genre=a;
			return this;
    	}
    	
    	public Book build() {
    		return new Book(this);
    	}
    }


}

