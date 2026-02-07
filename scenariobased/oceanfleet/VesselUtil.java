package week04.scenariobased.oceanfleet;

import java.util.ArrayList;
import java.util.List;

public class VesselUtil {

	private List<Vessel> vesselList = new ArrayList<>();

	public List<Vessel> getVesselList() {
		return vesselList;
	}

	public void setVesselList(List<Vessel> vesselList) {
		this.vesselList = vesselList;
	}

	public void addVesselPerformance(Vessel vessel) {

		vesselList.add(vessel);

	}

	public Vessel getVesselById(String vesselId) {

		return vesselList.stream().filter(x -> x.getVesselId().equals(vesselId)).findFirst().orElse(null);

	}

	public List<Vessel> getHighPerformanceVessels() {
		
		double max = vesselList.stream().mapToDouble(x -> x.getAverageSpeed()).max().orElse(0);
		
		return vesselList.stream().filter(x -> x.getAverageSpeed()==max).toList();
	}

}
