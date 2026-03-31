package scenarioBased;


public class DigitalWatch {

	public static void main(String[] args) {
		//Digital Watch Simulation
		for(int hour=0;hour<24;hour++) {
			
			for(int min=0;min<60;min++) {
			
				//check for power cut
				if(hour==13 && min==0) {
					System.out.println("Power Cut at 13:00 ");
					break;
				}
				System.out.println(hour+":"+min);
			}
			if(hour==13) {
				break;
			}

		}
		System.out.println("Watch Stooped due to power cut !!...");

	}

}
