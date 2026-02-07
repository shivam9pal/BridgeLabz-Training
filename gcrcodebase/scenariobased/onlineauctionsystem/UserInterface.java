package week08.scenariobased.onlineauctionsystem;

class UserInterface {
	public static void main(String[] args) {
		try {
			User u1 = new User("U1", "rahul");
            User u2 = new User("U2", "nakul");
            
            AuctionItem item = new AuctionItem("MacBook Pro");
            
            item.placeBid(new Bid(u1, 50000));
            item.placeBid(new Bid(u2, 60000));
            item.placeBid(new Bid(u1, 55000));
            
		} catch (InvalidBidException  e) {
			 System.out.println("Bid Error: " + e.getMessage());
		}
	}
}
