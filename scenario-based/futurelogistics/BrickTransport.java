package week02.scenario.futurelogistics;

public class BrickTransport extends GoodsTransport{
	private float brickSize;
	private int brickQuantity;
	private float brickPrice;
	
	public BrickTransport(String transportId, String transportDate, int transportRating, float brickSize,
			int brickQuantity, float brickPrice) {
		super(transportId, transportDate, transportRating);
		this.brickSize = brickSize;
		this.brickQuantity = brickQuantity;
		this.brickPrice = brickPrice;
	}
	public float getBrickSize() {
		return brickSize;
	}
	public void setBrickSize(float brickSize) {
		this.brickSize = brickSize;
	}
	public int getBrickQuantity() {
		return brickQuantity;
	}
	public void setBrickQuantity(int brickQuantity) {
		this.brickQuantity = brickQuantity;
	}
	public float getBrickPrice() {
		return brickPrice;
	}
	public void setBrickPrice(float brickPrice) {
		this.brickPrice = brickPrice;
	}
	
	@Override
	public String vehicleSelection() {
		if(brickQuantity<300) {
			return "Truck";
		}else if(brickQuantity>=300 && brickQuantity<=500) {
			return "Lorry";
		}
		return "MonsterLorry";
	}
	@Override
	public float totalCharge() {
		//calculating total charge 
		float price=brickPrice*brickQuantity;
		
		//tax
		double tax=0.3*price;
		
		//discount
		double discount;
		
		if(getTransportRating()==5) {
			discount=price*0.2;
		}else if(getTransportRating()>3 && getTransportRating()<=4) {
			discount=price*0.1;
		}else {
			discount=0;
		}
		
		float totalCharge=(float)(((price+getVehiclePrice()+tax))-discount);
		
		return totalCharge;
	}
	
	
	//get vehicle price 
	public float getVehiclePrice() {
		if(vehicleSelection().equals("Truck")) {
			return 1000;
		}else if(vehicleSelection().equals("Lorry")) {
			return 1700;
		}
		
		return 3000;
	}
	
	
	
}
