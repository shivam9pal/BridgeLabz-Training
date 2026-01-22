package week04.gcrcodebase.collections.insurancepolicysanagementsystem;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

class PolicyImpl {
	
	public static void main(String[] args) {
	 PolicyManager manager = new PolicyManager();

     Policy p1 = new Policy(101, "Alice",
             LocalDate.now().plusDays(20), "Health", 5000);

     Policy p2 = new Policy(102, "Bob",
             LocalDate.now().plusDays(50), "Auto", 3000);

     Policy p3 = new Policy(103, "Carol",
             LocalDate.now().plusDays(10), "Health", 4000);

     Policy p4 = new Policy(101, "Duplicate",
             LocalDate.now().plusDays(90), "Home", 2000);

     manager.addPolicy(p1);
     manager.addPolicy(p2);
     manager.addPolicy(p3);

     manager.displayAllPolicies();
     manager.policiesExpiringSoon();
     manager.policiesByCoverage("Health");

     List<Policy> all = Arrays.asList(p1, p2, p3, p4);
     manager.findDuplicates(all);

     manager.performanceTest();
	}
}
