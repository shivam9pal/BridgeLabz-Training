package week03.scenariobased.bookshelf;

class BookShelfM {
	public static void main(String[] args) {
		BookShelf shelf = new BookShelf();
        shelf.addBook("Fiction", "Harry Potter");
        shelf.addBook("Fiction", "Hobbit");
        shelf.addBook("Science", "Brief History of Time");
        shelf.addBook("Fiction", "Harry Potter");
        // Duplicate

        shelf.printCatalog();
        shelf.removeBook("Fiction", "Hobbit");
        shelf.printCatalog();
	}
}
