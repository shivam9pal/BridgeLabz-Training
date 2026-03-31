package week02.scenario.onlinevotingsystem;

public class Candidate {

    private int candidateId;
    private String candidateName;
    private String partyName;
    private String partySymbol;
    private String constituency;
    private int totalVotes;
    private String candidateDescription;

    public Candidate(int candidateId, String candidateName, String partyName, String partySymbol,
            String constituency, String candidateDescription) {
        this.candidateId = candidateId;
        this.candidateName = candidateName;
        this.partyName = partyName;
        this.partySymbol = partySymbol;
        this.constituency = constituency;
        this.totalVotes = 0;
        this.candidateDescription = candidateDescription;
    }

    public int getCandidateId() {
        return candidateId;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public String getPartyName() {
        return partyName;
    }

    public String getPartySymbol() {
        return partySymbol;
    }

    public String getConstituency() {
        return constituency;
    }

    public int getTotalVotes() {
        return totalVotes;
    }

    public String getCandidateDescription() {
        return candidateDescription;
    }

    public void addVote() {
        this.totalVotes++;
    }

    public void removeVote() {
        if (this.totalVotes > 0) {
            this.totalVotes--;
        }
    }

    public void setTotalVotes(int votes) {
        this.totalVotes = votes;
    }

    @Override
    public String toString() {
        return "ID: " + candidateId
                + " | Name: " + candidateName
                + " | Party: " + partyName
                + " | Symbol: " + partySymbol
                + " | Constituency: " + constituency
                + " | Votes: " + totalVotes;
    }
}
