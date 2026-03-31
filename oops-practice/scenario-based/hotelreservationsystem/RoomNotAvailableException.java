package week02.scenario.hotelreservationsystem;

class RoomNotAvailableException extends Exception {
	RoomNotAvailableException(String msg){
		super(msg);
	}
}
