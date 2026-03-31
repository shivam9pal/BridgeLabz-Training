package week03.scenariobased.trafficmanager;

class Vehicle {
	String number;
	Vehicle next;
	
	Vehicle(String number){
		this.number=number;
		this.next=null;
	}
}
