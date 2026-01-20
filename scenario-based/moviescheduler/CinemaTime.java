package week03.scenariobased.moviescheduler;

import java.util.ArrayList;
import java.util.List;

class CinemaTime {

	private List<String> titles = new ArrayList<>();
    private List<String> times = new ArrayList<>();
    
    // Add movie 
    void addMovie(String title, String time) throws InvalidTimeFormatException {
        if (!isValidTime(time)) {
            throw new InvalidTimeFormatException("Invalid Time: " + time);
        }

        titles.add(title);
        times.add(time);
        System.out.println("Added: " + title + " at " + time);
    }
    
    // Search
    void searchMovie(String keyword) {
        boolean found = false;
        for (int i = 0; i < titles.size(); i++) {
            if (titles.get(i).toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(titles.get(i) + " at " + times.get(i));
                found = true;
            }
        }
        if (!found) {
            System.out.println("No movie found for: " + keyword);
        }
    }
    
    // Display all movies
    void displayAllMovies() {
        for (int i = 0; i < titles.size(); i++) {
            System.out.println(String.format("%d. %s - %s", i + 1, titles.get(i), times.get(i)));
        }
    }
    
    // Convert  array for report
    void generateReport() {
        String[] report = titles.toArray(new String[0]);
        System.out.println("\nReport Titles:");
        for (String s : report) {
            System.out.println(s);
        }
    }
    
    
    
    // Time validation 
    private boolean isValidTime(String time) {
        try {
            String[] parts = time.split(":");
            int h = Integer.parseInt(parts[0]);
            int m = Integer.parseInt(parts[1]);
            return h >= 0 && h < 24 && m >= 0 && m < 60;
        } catch (Exception e) {
            return false;
        }
    }
}	
