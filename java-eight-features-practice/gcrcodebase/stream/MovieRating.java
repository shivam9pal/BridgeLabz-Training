package week06.gcrcodebase.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Movie {
    String name;
    double rating;
    int year;

    public Movie(String name, double rating, int year) {
        this.name = name;
        this.rating = rating;
        this.year = year;
    }

    @Override
    public String toString() {
        return name + " | Rating: " + rating + " | Year: " + year;
    }
}
class MovieRating {
	public static void main(String[] args) {
		List<Movie> movies = Arrays.asList(
                new Movie("Movie A", 8.5, 2022),
                new Movie("Movie B", 9.0, 2023),
                new Movie("Movie C", 8.8, 2021),
                new Movie("Movie D", 9.2, 2020),
                new Movie("Movie E", 7.5, 2024),
                new Movie("Movie F", 9.1, 2022),
                new Movie("Movie G", 8.9, 2023)
        );
		
		System.out.println("Top 5 treanding movies...!!");
		
		movies.stream()
	      .filter(m -> m.rating > 8)
	      .sorted(
	          Comparator
	              .comparing((Movie m) -> m.rating).reversed()
	              .thenComparing(
	                  Comparator.comparing((Movie m) -> m.year).reversed()
	              )
	      )
	      .limit(5)
	      .forEach(System.out::println);
						
	}
}


























