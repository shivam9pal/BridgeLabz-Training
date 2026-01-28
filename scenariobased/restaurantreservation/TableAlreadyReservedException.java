package week04.scenariobased.restaurantreservation;

class TableAlreadyReservedException extends Exception {
	 TableAlreadyReservedException(String msg){
		 super(msg);
	 }
}
