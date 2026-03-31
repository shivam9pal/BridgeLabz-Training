package week02.scenario.futurelogistics;

public class TimberTransport extends GoodsTransport{
	private float timberLength;
	private float timberRadius;
	private String timberType;
	private float timberPrice;
	public TimberTransport(String transportId, String transportDate, int transportRating, float timberLength,
			float timberRadius, String timberType, float timberPrice) {
		super(transportId, transportDate, transportRating);
		this.timberLength = timberLength;
		this.timberRadius = timberRadius;
		this.timberType = timberType;
		this.timberPrice = timberPrice;
	}
	
	public float getTimberLength() {
		return timberLength;
	}
	public void setTimberLength(float timberLength) {
		this.timberLength = timberLength;
	}
	public float getTimberRadius() {
		return timberRadius;
	}
	public void setTimberRadius(float timberRadius) {
		this.timberRadius = timberRadius;
	}
	public String getTimberType() {
		return timberType;
	}
	public void setTimberType(String timberType) {
		this.timberType = timberType;
	}
	public float getTimberPrice() {
		return timberPrice;
	}
	public void setTimberPrice(float timberPrice) {
		this.timberPrice = timberPrice;
	}

	@Override
	public String vehicleSelection() {
		//vehicle selection
		float timberArea=(float) (2*3.147*timberRadius*timberLength);
		if(timberArea<250) {
			return "Truck";
		}else if(timberArea<=400) {
			return "Lorry";
		}
		return "MonsterLorry";
	}

	@Override
	public float totalCharge() {
		
		//tax
		
		//volume
		float volume=(float) (3.147*timberRadius*timberRadius*timberLength);
		//price
		
		float price=volume*timberPrice*getTimberPremium();
		
		//tax
		
		double tax=price*0.3;
		
		//discount
		
		double discount;
		
		if(getTransportRating()==5) {
			discount=price*0.2;
		}else if(getTransportRating()>3 && getTransportRating()<=4) {
			discount=price*0.1;
		}else {
			discount=0;
		}	
		float totalCharge=(float) ((price+getVehiclePrice()+tax)-discount);
		return totalCharge;
	}

	private float getTimberPremium() {
		if(timberType.equalsIgnoreCase("Premium")) {
			return (float) 1.25;
		}
		return (float) 1.15;
	}
	public float getVehiclePrice() {
		if(vehicleSelection().equals("Truck")) {
			return 1000;
		}else if(vehicleSelection().equals("Lorry")) {
			return 1700;
		}
		
		return 3000;
	}
		
		
	
	
	
}
