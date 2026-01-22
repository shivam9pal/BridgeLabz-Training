package week04.gcrcodebase.collections.votingsysytem;

import java.util.*;

class VotingSystem {

    // stores total votes for each candidate
    private Map<String, Integer> voteCount = new HashMap<>();

    // stores votes in the order they were cast
    private Map<Integer, String> voteOrder = new LinkedHashMap<>();

    private int voteId = 1;

    // cast a vote
    void castVote(String candidate) {
        
        voteCount.put(candidate, voteCount.getOrDefault(candidate, 0) + 1);

        
        voteOrder.put(voteId++, candidate);
    }

    // display votes in the order they were cast
    void displayVoteOrder() {
        System.out.println("\nVote Order:");
        for (Map.Entry<Integer, String> entry : voteOrder.entrySet()) {
            System.out.println("Vote " + entry.getKey() + " -> " + entry.getValue());
        }
    }

    // display final results 
    void displaySortedResults() {
        System.out.println("\nFinal Results (Sorted):");

        TreeMap<String, Integer> sortedResults = new TreeMap<>(voteCount);

        for (Map.Entry<String, Integer> entry : sortedResults.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}
