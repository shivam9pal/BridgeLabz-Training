package week3dsa.linkedlist.moviemanagement;

// Node class for doubly linked list
class Movie {
    String title;
    String director;
    int year;
    double rating;
    
    Movie next; // Pointer to next node
    Movie prev; // Pointer to previous node
    
    public Movie(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
    
    @Override
    public String toString() {
        return String.format("Title: %s | Director: %s | Year: %d | Rating: %.1f", 
                            title, director, year, rating);
    }
}
