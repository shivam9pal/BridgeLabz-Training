package week03.scenariobased.moviescheduler;

class CinemaManager {
	 public static void main(String[] args) {
	        CinemaTime ct = new CinemaTime();
	        try {
	            ct.addMovie("Avatar", "10:30");
	            ct.addMovie("Inception", "14:00");
	            ct.addMovie("Avengers", "25:99"); 
	        } catch (InvalidTimeFormatException e) {
	            System.out.println(e.getMessage());
	        }

	        ct.displayAllMovies();
	        ct.searchMovie("Incep");

	        ct.generateReport();

	        //IndexOutOfBounds 
	        try {
	            System.out.println(ct.toString().charAt(100));
	        } catch (IndexOutOfBoundsException e) {
	            System.out.println("Invalid index accessed!");
	        }
	    }
}
