package review.flighbookingsystem;

public class User {
	private int id;
	private String name;
	private String phoneNo;
	
	User(int id,String name,String phoneNo){
		this.id=id;
		this.name=name;
		this.phoneNo=phoneNo;
	}

	int getId() {
		return id;
	}

	String getName() {
		return name;
	}

	String getPhoneNo() {
		return phoneNo;
	}
	

	@Override
	public String toString() {
		return "User \nid=" + id + ",\n name=" + name + ",\n phoneNo=" + phoneNo + "\n";
	}
	
	
}
