package collectors;

import java.util.*;
import java.util.stream.Collectors;

class Book {
	private String title;
	private String genre;
	private int pages;

	public Book(String title, String genre, int pages) {
		this.title = title;
		this.genre = genre;
		this.pages = pages;
	}

	public String getTitle() {
		return title;
	}

	public String getGenre() {
		return genre;
	}

	public int getPages() {
		return pages;
	}
}

public class BookStatistics {

	public static void main(String[] args) {

		List<Book> books = Arrays.asList(new Book("Java Basics", "Technology", 350),
				new Book("Spring in Action", "Technology", 520), new Book("The Alchemist", "Fiction", 210),
				new Book("Harry Potter", "Fiction", 450), new Book("History of India", "History", 600));

		Map<String, IntSummaryStatistics> statsByGenre = books.stream()
				.collect(Collectors.groupingBy(Book::getGenre, Collectors.summarizingInt(Book::getPages)));

		statsByGenre.forEach((genre, stats) -> {
			System.out.println("Genre: " + genre);
			System.out.println("  Total Pages   : " + stats.getSum());
			System.out.println("  Average Pages : " + stats.getAverage());
			System.out.println("  Max Pages     : " + stats.getMax());
		});
	}
}
