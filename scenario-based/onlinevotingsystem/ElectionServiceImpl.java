package week02.scenario.onlinevotingsystem;

import java.util.*;

public class ElectionServiceImpl implements ElectionService {

    private Map<Integer, Voter> voters;
    private Map<Integer, Candidate> candidates;
    private Map<Integer, Vote> votes;
    private int voteIdCounter = 3001;
    private boolean electionIsActive;

    public ElectionServiceImpl() {
        this.voters = new HashMap<>();
        this.candidates = new HashMap<>();
        this.votes = new HashMap<>();
        this.electionIsActive = false;
        initializeData();
    }

    private void initializeData() {
        // Initialize sample candidates
        addCandidate(401, "Rahul Gandhi", "Indian National Congress", "Hand", "New Delhi",
                "Experienced leader focused on social welfare");
        addCandidate(402, "Narendra Modi", "Bharatiya Janata Party", "Lotus", "New Delhi",
                "Leader with focus on economic development");
        addCandidate(403, "Arvind Kejriwal", "Aam Aadmi Party", "Broom", "New Delhi",
                "Social activist turned politician");
        addCandidate(404, "Mamata Banerjee", "All India Trinamool Congress", "Flower", "West Bengal",
                "Regional leader with grassroots support");

        // Initialize sample voters
        registerVoter(5001, "Amit Kumar", "amit@example.com", "9876543210", "1234567890123456");
        registerVoter(5002, "Priya Singh", "priya@example.com", "9876543211", "1234567890123457");
        registerVoter(5003, "Rahul Patel", "rahul@example.com", "9876543212", "1234567890123458");
        registerVoter(5004, "Sneha Sharma", "sneha@example.com", "9876543213", "1234567890123459");
        registerVoter(5005, "Vikram Verma", "vikram@example.com", "9876543214", "1234567890123460");
    }

    @Override
    public void registerVoter(int voterId, String name, String email, String phone, String aadhar) {
        Voter voter = new Voter(voterId, name, email, phone, aadhar);
        voters.put(voterId, voter);
        System.out.println("✓ Voter registered successfully!");
    }

    @Override
    public Voter getVoter(int voterId) {
        return voters.get(voterId);
    }

    @Override
    public void displayAllVoters() {
        System.out.println("\n" + "=".repeat(120));
        System.out.println("ALL REGISTERED VOTERS");
        System.out.println("=".repeat(120));
        if (voters.isEmpty()) {
            System.out.println("No voters registered!");
        } else {
            int count = 1;
            for (Voter voter : voters.values()) {
                System.out.println(count + ". " + voter);
                count++;
            }
        }
        System.out.println("=".repeat(120));
    }

    @Override
    public void addCandidate(int candidateId, String name, String party, String symbol,
            String constituency, String description) {
        Candidate candidate = new Candidate(candidateId, name, party, symbol, constituency, description);
        candidates.put(candidateId, candidate);
        System.out.println("✓ Candidate added successfully!");
    }

    @Override
    public Candidate getCandidate(int candidateId) {
        return candidates.get(candidateId);
    }

    @Override
    public void displayAllCandidates() {
        System.out.println("\n" + "=".repeat(120));
        System.out.println("ALL CANDIDATES");
        System.out.println("=".repeat(120));
        if (candidates.isEmpty()) {
            System.out.println("No candidates registered!");
        } else {
            int count = 1;
            for (Candidate candidate : candidates.values()) {
                System.out.println(count + ". " + candidate);
                count++;
            }
        }
        System.out.println("=".repeat(120));
    }

    @Override
    public void castVote(int voterId, int candidateId, String ipAddress) throws DuplicateVoteException, Exception {
        Voter voter = voters.get(voterId);
        Candidate candidate = candidates.get(candidateId);

        if (voter == null) {
            throw new Exception("Voter not found!");
        }
        if (candidate == null) {
            throw new Exception("Candidate not found!");
        }
        if (!electionIsActive) {
            throw new Exception("Election is not active! Voting is not allowed.");
        }
        if (voter.hasVoted()) {
            throw new DuplicateVoteException("You have already voted! One vote per voter only.");
        }

        // Record the vote
        Vote vote = new Vote(voteIdCounter++, voterId, candidateId, ipAddress);
        votes.put(vote.getVoteId(), vote);

        // Update voter and candidate
        voter.setVoted(true);
        voter.setCandidateVotedFor(candidateId);
        candidate.addVote();

        System.out.println("✓ Vote cast successfully!");
        System.out.println("  Candidate: " + candidate.getCandidateName() + " (" + candidate.getPartyName() + ")");
    }

    @Override
    public void displayVoteRecord(int voteId) {
        Vote vote = votes.get(voteId);
        if (vote != null) {
            System.out.println("\n" + "=".repeat(100));
            System.out.println("VOTE RECORD");
            System.out.println("=".repeat(100));
            System.out.println(vote);
            System.out.println("=".repeat(100));
        } else {
            System.out.println("✗ Vote record not found!");
        }
    }

    @Override
    public void displayElectionResults() {
        System.out.println("\n" + "=".repeat(120));
        System.out.println("ELECTION RESULTS");
        System.out.println("=".repeat(120));

        List<Candidate> sortedCandidates = new ArrayList<>(candidates.values());
        sortedCandidates.sort((c1, c2) -> Integer.compare(c2.getTotalVotes(), c1.getTotalVotes()));

        int position = 1;
        for (Candidate candidate : sortedCandidates) {
            double percentage = (votes.size() > 0) ? (candidate.getTotalVotes() * 100.0) / votes.size() : 0;
            System.out.println(position + ". " + candidate.getCandidateName() + " (" + candidate.getPartyName()
                    + ") - Votes: " + candidate.getTotalVotes() + " ("
                    + String.format("%.2f", percentage) + "%)");
            position++;
        }
        System.out.println("=".repeat(120));
    }

    @Override
    public Candidate getWinner() {
        if (candidates.isEmpty()) {
            return null;
        }

        Candidate winner = null;
        int maxVotes = -1;
        for (Candidate candidate : candidates.values()) {
            if (candidate.getTotalVotes() > maxVotes) {
                maxVotes = candidate.getTotalVotes();
                winner = candidate;
            }
        }
        return winner;
    }

    @Override
    public void displayVoterTurnout() {
        System.out.println("\n" + "=".repeat(100));
        System.out.println("VOTER TURNOUT");
        System.out.println("=".repeat(100));

        int totalVoters = voters.size();
        int votedVoters = 0;

        for (Voter voter : voters.values()) {
            if (voter.hasVoted()) {
                votedVoters++;
            }
        }

        double turnoutPercentage = (totalVoters > 0) ? (votedVoters * 100.0) / totalVoters : 0;

        System.out.println("Total Registered Voters: " + totalVoters);
        System.out.println("Voters Who Cast Vote: " + votedVoters);
        System.out.println("Voter Turnout: " + String.format("%.2f", turnoutPercentage) + "%");
        System.out.println("=".repeat(100));
    }

    @Override
    public void displayVotingStatistics() {
        System.out.println("\n" + "=".repeat(100));
        System.out.println("VOTING STATISTICS");
        System.out.println("=".repeat(100));

        int totalVotes = votes.size();
        int verifiedVotes = 0;

        for (Vote vote : votes.values()) {
            if (vote.isVerified()) {
                verifiedVotes++;
            }
        }

        System.out.println("Total Votes Cast: " + totalVotes);
        System.out.println("Verified Votes: " + verifiedVotes);
        System.out.println("Invalid Votes: " + (totalVotes - verifiedVotes));
        System.out.println("Total Candidates: " + candidates.size());
        System.out.println("Total Registered Voters: " + voters.size());
        System.out.println("=".repeat(100));
    }

    public void startElection() {
        electionIsActive = true;
        System.out.println("✓ Election started! Voting is now active.");
    }

    public void endElection() {
        electionIsActive = false;
        System.out.println("✓ Election ended! Voting is now closed.");
    }

    public boolean isElectionActive() {
        return electionIsActive;
    }

    public Map<Integer, Vote> getAllVotes() {
        return votes;
    }

    public Map<Integer, Candidate> getAllCandidates() {
        return candidates;
    }

    public Map<Integer, Voter> getAllVoters() {
        return voters;
    }
}
