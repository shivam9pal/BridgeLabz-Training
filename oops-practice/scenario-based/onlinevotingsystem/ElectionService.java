package week02.scenario.onlinevotingsystem;

import java.util.*;

public interface ElectionService {

    // Voter Management
    void registerVoter(int voterId, String name, String email, String phone, String aadhar);

    Voter getVoter(int voterId);

    void displayAllVoters();

    // Candidate Management
    void addCandidate(int candidateId, String name, String party, String symbol, String constituency, String description);

    Candidate getCandidate(int candidateId);

    void displayAllCandidates();

    // Voting
    void castVote(int voterId, int candidateId, String ipAddress) throws DuplicateVoteException, Exception;

    void displayVoteRecord(int voteId);

    // Results
    void displayElectionResults();

    Candidate getWinner();

    void displayVoterTurnout();

    void displayVotingStatistics();
}
