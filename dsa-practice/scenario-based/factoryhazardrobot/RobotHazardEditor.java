package week03.scenariobased.factoryhazardrobot;

class RobotHazardEditor {
	
	public double calculateHazardRisk(double armPricison, int workerDensity, String machineryState) throws RobotSafetyException {
		
		if(!(armPricison<=1 && armPricison>=0)) {
			throw new RobotSafetyException("Error: Arm precision must be 0.0-1.0");
		}		
		
		if(!(workerDensity<=20 && workerDensity>=1)) {
			throw new RobotSafetyException("Error: Worker density must be 1-20");
		}		
		
		
		double machineRiskfactor=0;
		if(machineryState.equals("Worn")) {
			machineRiskfactor=1.3;
		}else if(machineryState.equals("Faulty")) {
			machineRiskfactor=2.0;
		}else if(machineryState.equals("Critical")) {
			machineRiskfactor=3.0;
		}else {
			throw new RobotSafetyException("Error: Unsupported machinery state");
		}
		
		
		double hazardRisk=((1.0-armPricison)*15.0)+(workerDensity*machineRiskfactor);
		
		return hazardRisk;
		
		
	}
}
