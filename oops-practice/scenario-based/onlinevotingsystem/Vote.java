package week02.scenario.onlinevotingsystem;

public class Vote {

    private int voteId;
    private int voterId;
    private int candidateId;
    private String votingTime;
    private String votingIPAddress;
    private boolean isVerified;

    public Vote(int voteId, int voterId, int candidateId, String ipAddress) {
        this.voteId = voteId;
        this.voterId = voterId;
        this.candidateId = candidateId;
        this.votingIPAddress = ipAddress;
        this.votingTime = new java.time.LocalDateTime.now().toString();
        this.isVerified = true;
    }

    public int getVoteId() {
        return voteId;
    }

    public int getVoterId() {
        return voterId;
    }

    public int getCandidateId() {
        return candidateId;
    }

    public String getVotingTime() {
        return votingTime;
    }

    public String getVotingIPAddress() {
        return votingIPAddress;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean verified) {
        this.isVerified = verified;
    }

    @Override
    public String toString() {
        return "Vote ID: " + voteId
                + " | Voter ID: " + voterId
                + " | Candidate ID: " + candidateId
                + " | Time: " + votingTime
                + " | IP: " + votingIPAddress
                + " | Verified: " + (isVerified ? "YES" : "NO");
    }
}
