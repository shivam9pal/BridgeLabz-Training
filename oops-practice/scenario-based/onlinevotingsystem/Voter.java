package week02.scenario.onlinevotingsystem;

public class Voter {

    private int voterId;
    private String voterName;
    private String email;
    private String phoneNumber;
    private String adharNumber;
    private boolean hasVoted;
    private int candidateVotedFor;

    public Voter(int voterId, String voterName, String email, String phoneNumber, String adharNumber) {
        this.voterId = voterId;
        this.voterName = voterName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.adharNumber = adharNumber;
        this.hasVoted = false;
        this.candidateVotedFor = -1;
    }

    public int getVoterId() {
        return voterId;
    }

    public String getVoterName() {
        return voterName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAdharNumber() {
        return adharNumber;
    }

    public boolean hasVoted() {
        return hasVoted;
    }

    public void setVoted(boolean voted) {
        this.hasVoted = voted;
    }

    public int getCandidateVotedFor() {
        return candidateVotedFor;
    }

    public void setCandidateVotedFor(int candidateId) {
        this.candidateVotedFor = candidateId;
    }

    @Override
    public String toString() {
        return "Voter ID: " + voterId
                + " | Name: " + voterName
                + " | Email: " + email
                + " | Phone: " + phoneNumber
                + " | Aadhar: " + adharNumber
                + " | Status: " + (hasVoted ? "VOTED" : "NOT VOTED");
    }
}
