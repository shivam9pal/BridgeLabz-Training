package week02.addressbook;

class PersonDoesNotExistException extends Exception{
	PersonDoesNotExistException(String message){
		super(message);
	}

}
