package week02.scenario.onlinevotingsystem;

import java.util.*;

public class OnlineVotingApp {

    private ElectionService electionService;
    private Scanner scanner;
    private int currentVoterId = -1;
    private boolean isAdmin = false;

    public OnlineVotingApp() {
        this.electionService = new ElectionServiceImpl();
        this.scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        OnlineVotingApp app = new OnlineVotingApp();
        app.run();
    }

    public void run() {
        System.out.println("\n╔════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                        ONLINE VOTING SYSTEM                                    ║");
        System.out.println("╚════════════════════════════════════════════════════════════════════════════════╝");

        boolean running = true;
        while (running) {
            if (isAdmin) {
                running = handleAdminMenu();
            } else if (currentVoterId == -1) {
                running = handleLoginMenu();
            } else {
                running = handleVoterMenu();
            }
        }

        System.out.println("\n╔════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                    Thank you for voting! Goodbye!                              ║");
        System.out.println("╚════════════════════════════════════════════════════════════════════════════════╝");
        scanner.close();
    }

    // ====== LOGIN MENU ======
    private boolean handleLoginMenu() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("LOGIN");
        System.out.println("=".repeat(80));
        System.out.println("1. Login as Voter");
        System.out.println("2. Login as Admin");
        System.out.println("3. Register as New Voter");
        System.out.println("4. Exit");
        System.out.println("=".repeat(80));
        System.out.print("Enter your choice: ");

        int choice = getIntInput();

        switch (choice) {
            case 1:
                loginVoter();
                break;
            case 2:
                loginAdmin();
                break;
            case 3:
                registerNewVoter();
                break;
            case 4:
                return false;
            default:
                System.out.println("✗ Invalid choice! Please try again.");
        }
        return true;
    }

    private void loginVoter() {
        System.out.println("\n" + "-".repeat(80));
        System.out.println("VOTER LOGIN");
        System.out.println("-".repeat(80));

        System.out.print("Enter Voter ID: ");
        int voterId = getIntInput();

        Voter voter = electionService.getVoter(voterId);
        if (voter != null) {
            currentVoterId = voterId;
            System.out.println("✓ Welcome, " + voter.getVoterName() + "!");
        } else {
            System.out.println("✗ Voter ID not found! Please register first.");
        }
    }

    private void loginAdmin() {
        System.out.println("\n" + "-".repeat(80));
        System.out.println("ADMIN LOGIN");
        System.out.println("-".repeat(80));

        System.out.print("Enter Admin Password (demo: election2024): ");
        String password = scanner.nextLine().trim();

        if (password.equals("election2024")) {
            isAdmin = true;
            System.out.println("✓ Admin login successful!");
        } else {
            System.out.println("✗ Invalid password!");
        }
    }

    private void registerNewVoter() {
        System.out.println("\n" + "-".repeat(80));
        System.out.println("NEW VOTER REGISTRATION");
        System.out.println("-".repeat(80));

        System.out.print("Enter Voter ID: ");
        int voterId = getIntInput();

        System.out.print("Enter Full Name: ");
        String name = scanner.nextLine().trim();

        System.out.print("Enter Email: ");
        String email = scanner.nextLine().trim();

        System.out.print("Enter Phone Number: ");
        String phone = scanner.nextLine().trim();

        System.out.print("Enter Aadhar Number: ");
        String aadhar = scanner.nextLine().trim();

        electionService.registerVoter(voterId, name, email, phone, aadhar);
        currentVoterId = voterId;
        System.out.println("✓ Welcome, " + name + "!");
    }

    // ====== ADMIN MENU ======
    private boolean handleAdminMenu() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("ADMIN MENU");
        System.out.println("=".repeat(80));
        System.out.println("1. Start Election");
        System.out.println("2. End Election");
        System.out.println("3. Add Candidate");
        System.out.println("4. View All Candidates");
        System.out.println("5. View All Voters");
        System.out.println("6. View Election Results");
        System.out.println("7. Declare Winner");
        System.out.println("8. View Voter Turnout");
        System.out.println("9. View Voting Statistics");
        System.out.println("10. View Vote Records");
        System.out.println("11. Election Status");
        System.out.println("12. Logout");
        System.out.println("13. Exit");
        System.out.println("=".repeat(80));
        System.out.print("Enter your choice: ");

        int choice = getIntInput();

        switch (choice) {
            case 1:
                startElection();
                break;
            case 2:
                endElection();
                break;
            case 3:
                addCandidate();
                break;
            case 4:
                electionService.displayAllCandidates();
                break;
            case 5:
                electionService.displayAllVoters();
                break;
            case 6:
                electionService.displayElectionResults();
                break;
            case 7:
                declareWinner();
                break;
            case 8:
                electionService.displayVoterTurnout();
                break;
            case 9:
                electionService.displayVotingStatistics();
                break;
            case 10:
                viewVoteRecords();
                break;
            case 11:
                viewElectionStatus();
                break;
            case 12:
                isAdmin = false;
                System.out.println("✓ Logged out successfully!");
                break;
            case 13:
                return false;
            default:
                System.out.println("✗ Invalid choice!");
        }
        return true;
    }

    private void startElection() {
        System.out.println("\n" + "-".repeat(80));
        System.out.println("START ELECTION");
        System.out.println("-".repeat(80));

        if (((ElectionServiceImpl) electionService).isElectionActive()) {
            System.out.println("✗ Election is already active!");
        } else {
            ((ElectionServiceImpl) electionService).startElection();
        }
    }

    private void endElection() {
        System.out.println("\n" + "-".repeat(80));
        System.out.println("END ELECTION");
        System.out.println("-".repeat(80));

        if (!((ElectionServiceImpl) electionService).isElectionActive()) {
            System.out.println("✗ Election is not currently active!");
        } else {
            ((ElectionServiceImpl) electionService).endElection();
        }
    }

    private void addCandidate() {
        System.out.println("\n" + "-".repeat(80));
        System.out.println("ADD NEW CANDIDATE");
        System.out.println("-".repeat(80));

        System.out.print("Enter Candidate ID: ");
        int candidateId = getIntInput();

        System.out.print("Enter Candidate Name: ");
        String name = scanner.nextLine().trim();

        System.out.print("Enter Party Name: ");
        String party = scanner.nextLine().trim();

        System.out.print("Enter Party Symbol: ");
        String symbol = scanner.nextLine().trim();

        System.out.print("Enter Constituency: ");
        String constituency = scanner.nextLine().trim();

        System.out.print("Enter Candidate Description: ");
        String description = scanner.nextLine().trim();

        electionService.addCandidate(candidateId, name, party, symbol, constituency, description);
    }

    private void declareWinner() {
        System.out.println("\n" + "=".repeat(100));
        System.out.println("ELECTION WINNER DECLARATION");
        System.out.println("=".repeat(100));

        Candidate winner = electionService.getWinner();
        if (winner != null) {
            System.out.println("🏆 WINNER 🏆");
            System.out.println("-".repeat(100));
            System.out.println("Candidate: " + winner.getCandidateName());
            System.out.println("Party: " + winner.getPartyName() + " (" + winner.getPartySymbol() + ")");
            System.out.println("Constituency: " + winner.getConstituency());
            System.out.println("Total Votes: " + winner.getTotalVotes());
            System.out.println("=".repeat(100));
        } else {
            System.out.println("No votes cast yet!");
            System.out.println("=".repeat(100));
        }
    }

    private void viewVoteRecords() {
        System.out.println("\n" + "=".repeat(100));
        System.out.println("VOTE RECORDS");
        System.out.println("=".repeat(100));

        Map<Integer, Vote> votes = ((ElectionServiceImpl) electionService).getAllVotes();
        if (votes.isEmpty()) {
            System.out.println("No votes cast yet!");
        } else {
            int count = 1;
            for (Vote vote : votes.values()) {
                System.out.println(count + ". " + vote);
                count++;
            }
        }
        System.out.println("=".repeat(100));
    }

    private void viewElectionStatus() {
        System.out.println("\n" + "=".repeat(80));
        System.out.println("ELECTION STATUS");
        System.out.println("=".repeat(80));

        ElectionServiceImpl service = (ElectionServiceImpl) electionService;
        System.out.println("Election Status: " + (service.isElectionActive() ? "ACTIVE" : "INACTIVE"));
        System.out.println("Total Candidates: " + service.getAllCandidates().size());
        System.out.println("Total Registered Voters: " + service.getAllVoters().size());
        System.out.println("Total Votes Cast: " + service.getAllVotes().size());
        System.out.println("=".repeat(80));
    }

    // ====== VOTER MENU ======
    private boolean handleVoterMenu() {
        Voter voter = electionService.getVoter(currentVoterId);
        if (voter == null) {
            currentVoterId = -1;
            return true;
        }

        System.out.println("\n" + "=".repeat(80));
        System.out.println("VOTER MENU - " + voter.getVoterName());
        System.out.println("=".repeat(80));
        System.out.println("1. View My Profile");
        System.out.println("2. View All Candidates");
        System.out.println("3. View Candidate Details");
        System.out.println("4. Cast Vote");
        System.out.println("5. View Voting Status");
        System.out.println("6. View Election Results");
        System.out.println("7. View Voter Turnout");
        System.out.println("8. Logout");
        System.out.println("9. Exit");
        System.out.println("=".repeat(80));
        System.out.print("Enter your choice: ");

        int choice = getIntInput();

        switch (choice) {
            case 1:
                viewVoterProfile();
                break;
            case 2:
                electionService.displayAllCandidates();
                break;
            case 3:
                viewCandidateDetails();
                break;
            case 4:
                castVote();
                break;
            case 5:
                viewVotingStatus();
                break;
            case 6:
                electionService.displayElectionResults();
                break;
            case 7:
                electionService.displayVoterTurnout();
                break;
            case 8:
                currentVoterId = -1;
                System.out.println("✓ Logged out successfully!");
                break;
            case 9:
                return false;
            default:
                System.out.println("✗ Invalid choice!");
        }
        return true;
    }

    private void viewVoterProfile() {
        Voter voter = electionService.getVoter(currentVoterId);
        System.out.println("\n" + "=".repeat(100));
        System.out.println("MY PROFILE");
        System.out.println("=".repeat(100));
        System.out.println(voter);
        System.out.println("=".repeat(100));
    }

    private void viewCandidateDetails() {
        System.out.println("\n" + "-".repeat(80));
        System.out.println("VIEW CANDIDATE DETAILS");
        System.out.println("-".repeat(80));

        electionService.displayAllCandidates();

        System.out.print("Enter Candidate ID: ");
        int candidateId = getIntInput();

        Candidate candidate = electionService.getCandidate(candidateId);
        if (candidate != null) {
            System.out.println("\n" + "=".repeat(100));
            System.out.println("CANDIDATE DETAILS");
            System.out.println("=".repeat(100));
            System.out.println("ID: " + candidate.getCandidateId());
            System.out.println("Name: " + candidate.getCandidateName());
            System.out.println("Party: " + candidate.getPartyName());
            System.out.println("Party Symbol: " + candidate.getPartySymbol());
            System.out.println("Constituency: " + candidate.getConstituency());
            System.out.println("Description: " + candidate.getCandidateDescription());
            System.out.println("Current Votes: " + candidate.getTotalVotes());
            System.out.println("=".repeat(100));
        } else {
            System.out.println("✗ Candidate not found!");
        }
    }

    private void castVote() {
        System.out.println("\n" + "-".repeat(80));
        System.out.println("CAST YOUR VOTE");
        System.out.println("-".repeat(80));

        Voter voter = electionService.getVoter(currentVoterId);

        if (voter.hasVoted()) {
            System.out.println("✗ You have already cast your vote! One vote per voter only.");
            return;
        }

        electionService.displayAllCandidates();

        System.out.print("Enter Candidate ID to vote for: ");
        int candidateId = getIntInput();

        Candidate candidate = electionService.getCandidate(candidateId);
        if (candidate == null) {
            System.out.println("✗ Candidate not found!");
            return;
        }

        System.out.println("\nYou are voting for: " + candidate.getCandidateName()
                + " (" + candidate.getPartyName() + ")");
        System.out.print("Confirm your vote? (Y/N): ");
        String confirmation = scanner.nextLine().trim().toUpperCase();

        if (confirmation.equals("Y")) {
            try {
                String ipAddress = generateRandomIP();
                electionService.castVote(currentVoterId, candidateId, ipAddress);
                System.out.println("✓ Your vote has been securely recorded!");
            } catch (DuplicateVoteException e) {
                System.out.println("✗ " + e.getMessage());
            } catch (Exception e) {
                System.out.println("✗ Error: " + e.getMessage());
            }
        } else {
            System.out.println("Vote cancelled!");
        }
    }

    private void viewVotingStatus() {
        Voter voter = electionService.getVoter(currentVoterId);
        System.out.println("\n" + "=".repeat(80));
        System.out.println("YOUR VOTING STATUS");
        System.out.println("=".repeat(80));

        if (voter.hasVoted()) {
            Candidate candidate = electionService.getCandidate(voter.getCandidateVotedFor());
            System.out.println("Status: ✓ VOTED");
            System.out.println("Voted for: " + candidate.getCandidateName() + " (" + candidate.getPartyName() + ")");
        } else {
            System.out.println("Status: ✗ NOT VOTED");
            System.out.println("You have not cast your vote yet.");
        }
        System.out.println("=".repeat(80));
    }

    // ====== UTILITY METHODS ======
    private int getIntInput() {
        try {
            int value = Integer.parseInt(scanner.nextLine().trim());
            return value;
        } catch (NumberFormatException e) {
            System.out.println("✗ Invalid input! Please enter a number.");
            return -1;
        }
    }

    private String generateRandomIP() {
        Random rand = new Random();
        return rand.nextInt(256) + "." + rand.nextInt(256) + "."
                + rand.nextInt(256) + "." + rand.nextInt(256);
    }
}
