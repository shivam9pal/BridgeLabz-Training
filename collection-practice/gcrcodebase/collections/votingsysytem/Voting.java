package week04.gcrcodebase.collections.votingsysytem;

class Voting {
	public static void main(String[] args) {

        VotingSystem system = new VotingSystem();

        system.castVote("Ram");
        system.castVote("Shyam");
        system.castVote("Himanshu");
        system.castVote("Himani");
        system.castVote("Babul");

        system.displayVoteOrder();
        system.displaySortedResults();
    }
}
