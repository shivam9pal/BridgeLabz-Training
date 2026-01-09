package week3dsa.linkedlist.moviemanagement;

public class MovieLinkedList {
    
    private Movie head;
    private Movie tail;
    
    public MovieLinkedList() {
        this.head = null;
        this.tail = null;
    }
    
    // Add movie at beginning
    public void addAtBeginning(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        
        if (head == null) {
            head = tail = newMovie;
        } else {
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        }
        System.out.println("✓ Added at beginning: " + title);
    }
    
    // Add movie at end
    public void addAtEnd(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        
        if (tail == null) {
            head = tail = newMovie;
        } else {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
        System.out.println("✓ Added at end: " + title);
    }
    
    // Add at specific position
    public void addAtPosition(String title, String director, int year, double rating, int position) {
        if (position < 1) {
            System.out.println("✗ Position must be >= 1");
            return;
        }
        
        if (position == 1) {
            addAtBeginning(title, director, year, rating);
            return;
        }
        
        Movie newMovie = new Movie(title, director, year, rating);
        Movie temp = head;
        int count = 1;
        
        while (count < position - 1 && temp != null) {
            temp = temp.next;
            count++;
        }
        
        if (temp == null) {
            System.out.println("✗ Position out of bounds!");
            return;
        }
        
        newMovie.next = temp.next;
        newMovie.prev = temp;
        
        if (temp.next != null) {
            temp.next.prev = newMovie;
        } else {
            tail = newMovie;
        }
        
        temp.next = newMovie;
        System.out.println("✓ Added at position " + position + ": " + title);
    }
    
    // Remove movie by title
    public void removeByTitle(String title) {
        if (head == null) {
            System.out.println("✗ List is empty!");
            return;
        }
        
        Movie temp = head;
        
        while (temp != null && !temp.title.equalsIgnoreCase(title)) {
            temp = temp.next;
        }
        
        if (temp == null) {
            System.out.println("✗ Movie not found: " + title);
            return;
        }
        
        // Update pointers
        if (temp.prev != null) {
            temp.prev.next = temp.next;
        } else {
            head = temp.next;
        }
        
        if (temp.next != null) {
            temp.next.prev = temp.prev;
        } else {
            tail = temp.prev;
        }
        
        System.out.println("✓ Removed movie: " + title);
    }
    
    // Search by director
    public void searchByDirector(String director) {
        if (head == null) {
            System.out.println("✗ List is empty!");
            return;
        }
        
        Movie temp = head;
        boolean found = false;
        System.out.println("\nMovies by " + director + ":");
        
        while (temp != null) {
            if (temp.director.equalsIgnoreCase(director)) {
                System.out.println("  " + temp);
                found = true;
            }
            temp = temp.next;
        }
        
        if (!found) {
            System.out.println("  No movies found");
        }
    }
    
    // Search by rating
    public void searchByRating(double rating) {
        if (head == null) {
            System.out.println("✗ List is empty!");
            return;
        }
        
        Movie temp = head;
        boolean found = false;
        System.out.println("\nMovies with rating " + rating + ":");
        
        while (temp != null) {
            if (temp.rating == rating) {
                System.out.println("  " + temp);
                found = true;
            }
            temp = temp.next;
        }
        
        if (!found) {
            System.out.println("  No movies found");
        }
    }
    
    // Update rating by title
    public void updateRating(String title, double newRating) {
        Movie temp = head;
        
        while (temp != null && !temp.title.equalsIgnoreCase(title)) {
            temp = temp.next;
        }
        
        if (temp != null) {
            temp.rating = newRating;
            System.out.println("✓ Updated rating for " + title + " to " + newRating);
        } else {
            System.out.println("✗ Movie not found: " + title);
        }
    }
    
    // Display forward
    public void displayForward() {
        if (head == null) {
            System.out.println("✗ No movies in the list.");
            return;
        }
        
        System.out.println("\n=== Movies (Forward) ===");
        Movie temp = head;
        int position = 1;
        
        while (temp != null) {
            System.out.println(position + ". " + temp);
            temp = temp.next;
            position++;
        }
        System.out.println("========================\n");
    }
    
    // Display reverse
    public void displayReverse() {
        if (tail == null) {
            System.out.println("✗ No movies in the list.");
            return;
        }
        
        System.out.println("\n=== Movies (Reverse) ===");
        Movie temp = tail;
        int position = 1;
        
        while (temp != null) {
            System.out.println(position + ". " + temp);
            temp = temp.prev;
            position++;
        }
        System.out.println("========================\n");
    }
}
