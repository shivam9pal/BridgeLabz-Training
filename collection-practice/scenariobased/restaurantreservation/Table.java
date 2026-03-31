package week04.scenariobased.restaurantreservation;

class Table{
	String name;
	boolean isReserved;
	public Table(String name) {
		this.name=name;
		isReserved=false;
	}
	public void setIsReserved() {
		isReserved=true;
	}
	public void setNotReserved() {
		isReserved=false;
	}
	public boolean isReserved() {
		return isReserved;
	}
	
	@Override
	public String toString() {
		return "Table name: "+name+ "\\nIs Reserved : "+isReserved;
	}
	
}
