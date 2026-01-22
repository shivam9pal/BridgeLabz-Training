package week04.gcrcodebase.collections.insurancepolicysanagementsystem;

import java.time.LocalDate;

class Policy {
	int policyNumber;
	String holderName;
	LocalDate expiryDate;
	String coverageType;
	double premium;
	
	public Policy(int policyNumber,String holderName, LocalDate expiryDate, String coverageType, double premium) {
		this.policyNumber = policyNumber;
        this.holderName = holderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premium = premium;
	}
	
	//policy are unique by policy Number
	@Override
	public boolean equals(Object o) {
		if(this == o)return true;
		if(!(o instanceof Policy)) return false;
		Policy p=(Policy) o;
		return policyNumber==p.policyNumber;
		
	}
	
	@Override
	public int hashCode() {
		return policyNumber;
	}
	
	 @Override
	    public String toString() {
	        return policyNumber + " | " + holderName + " | " + expiryDate + " | "
	                + coverageType + " | " + premium;
	    }
}

