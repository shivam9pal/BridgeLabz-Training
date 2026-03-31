package week02.scenario;

public class TempratureAnalysis {

	    public static void analyze(float[][] temp){
	    	//initialize variable
	        int hottestDay = 0;
	        int coldestDay = 0;
	        float maxTemp = temp[0][0];
	        float minTemp = temp[0][0];
	        //checcking each variable
	        for (int i = 0; i < 7; i++) {
	            float sum = 0;
	            for (int j = 0; j < 24; j++) {
	                sum += temp[i][j];

	                if (temp[i][j] > maxTemp) {
	                    maxTemp = temp[i][j];
	                    hottestDay = i;
	                }

	                if (temp[i][j] < minTemp) {
	                    minTemp = temp[i][j];
	                    coldestDay = i;
	                }
	            }
	            System.out.println("Average temperature of day " + (i + 1) + " = " + (sum / 24));             
	        }
	        System.out.println("\nHottest day: Day " + (hottestDay + 1));
	        System.out.println("Coldest day: Day " + (coldestDay + 1));
	   }

		
		public static void main(String[] args) {
			float[][] temperatures = new float[7][24];
	        for (int i = 0; i < 7; i++) {
	            for (int j = 0; j < 24; j++) {
	                temperatures[i][j] = 20 + i + j * 0.1f;
	            }
	        }

	        analyze(temperatures);
		}

}
