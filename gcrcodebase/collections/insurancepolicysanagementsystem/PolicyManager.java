package week04.gcrcodebase.collections.insurancepolicysanagementsystem;

import java.time.LocalDate;
import java.util.*;

class PolicyManager {

	Set<Policy> hashSet = new HashSet<>();
    Set<Policy> linkedHashSet = new LinkedHashSet<>();

    Set<Policy> treeSet = new TreeSet<>(
            Comparator.comparing(p -> p.expiryDate)
    );
    
    // Add policy to all sets
    void addPolicy(Policy p) {
        hashSet.add(p);
        linkedHashSet.add(p);
        treeSet.add(p);
    }
    
    void displayAllPolicies() {
        System.out.println("\nAll Policies:");
        for (Policy p : hashSet) {
            System.out.println(p);
        }
    }
    
    void policiesExpiringSoon() {
        System.out.println("\nPolicies expiring in 30 days:");
        LocalDate now = LocalDate.now();

        for (Policy p : hashSet) {
            if (!p.expiryDate.isBefore(now) &&
                p.expiryDate.isBefore(now.plusDays(30))) {
                System.out.println(p);
            }
        }
    }
    
    void policiesByCoverage(String type) {
        System.out.println("\nPolicies with coverage: " + type);
        for (Policy p : hashSet) {
            if (p.coverageType.equalsIgnoreCase(type)) {
                System.out.println(p);
            }
        }
    }
    
    void findDuplicates(List<Policy> policies) {
        System.out.println("\nDuplicate policies:");

        Set<Integer> seen = new HashSet<>();
        for (Policy p : policies) {
            if (!seen.add(p.policyNumber)) {
                System.out.println(p);
            }
        }
    }
    
    void performanceTest() {
        int n = 100000;
        List<Policy> testData = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            testData.add(new Policy(i, "User" + i,
                    LocalDate.now().plusDays(i % 365),
                    "Health", 1000));
        }
        testSetPerformance(new HashSet<>(), testData, "HashSet");
        testSetPerformance(new LinkedHashSet<>(), testData, "LinkedHashSet");
        testSetPerformance(new TreeSet<>(Comparator.comparing(p -> p.expiryDate)),
                testData, "TreeSet");
    }
    
    
    void testSetPerformance(Set<Policy> set, List<Policy> data, String name) {

        long start, end;

        start = System.currentTimeMillis();
        set.addAll(data);
        end = System.currentTimeMillis();
        System.out.println(name + " Add Time: " + (end - start) + " ms");

        Policy search = data.get(data.size() / 2);
        start = System.currentTimeMillis();
        set.contains(search);
        end = System.currentTimeMillis();
        System.out.println(name + " Search Time: " + (end - start) + " ms");

        start = System.currentTimeMillis();
        set.remove(search);
        end = System.currentTimeMillis();
        System.out.println(name + " Remove Time: " + (end - start) + " ms");

        System.out.println();
    }
	
}
