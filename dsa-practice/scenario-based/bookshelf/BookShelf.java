package week03.scenariobased.bookshelf;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

class BookShelf {
	private Map<String, LinkedList<String>> catalog = new HashMap<>();
    private Set<String> allBooks = new HashSet<>();

    void addBook(String genre, String book) {
        if (allBooks.contains(book)) {
            System.out.println("Duplicate Book Ignored: " + book);
            return;
        }

        catalog.putIfAbsent(genre, new LinkedList<>());
        catalog.get(genre).add(book);
        allBooks.add(book);

        System.out.println("Added: " + book + " to " + genre);
    }

    void removeBook(String genre, String book) {
        if (!catalog.containsKey(genre)) return;

        catalog.get(genre).remove(book);
        allBooks.remove(book);

        System.out.println("Removed: " + book + " from " + genre);
    }

    void printCatalog() {
        System.out.println("\nLibrary Catalog:");
        for (String genre : catalog.keySet()) {
            System.out.println(genre + " -> " + catalog.get(genre));
        }
    }
}
