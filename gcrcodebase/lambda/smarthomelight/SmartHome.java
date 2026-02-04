package week06.gcrcodebase.lambda.smarthomelight;

class SmartHome {
	public static void main(String[] args) {
		SmartLight home=new SmartLight();
		
		LightBehavior motionBehavior=()->{
			System.out.println("Blinking light ");
		};
		
		LightBehavior nightBehavior=()->{
			System.out.println("Dim light ");
		};
		
		LightBehavior voiceBehavior=()->{
			System.out.println("As per command light ");
		};
		
		LightBehavior autoBehavior=()->{
			System.out.println("Disco light ");
		};
		
		home.runBehavior(autoBehavior);
		home.runBehavior(motionBehavior);
		home.runBehavior(nightBehavior);
		home.runBehavior(voiceBehavior);
		
		
		
	}
}
