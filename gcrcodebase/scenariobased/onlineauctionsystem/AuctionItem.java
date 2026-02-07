package week08.scenariobased.onlineauctionsystem;

import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

class AuctionItem {
	
	private String itemName;
	
	//store bids
	private TreeMap<User, Double> bids;
	
	public AuctionItem(String name) {
			this.itemName=itemName;
			this.bids=new TreeMap<>(Comparator.comparing(User::getId));
			
	}
	
	public void placeBid(Bid bid) throws InvalidBidException {
		double currentHighestBid=getHighestBid();
		
		if(bid.getAmount() <= currentHighestBid) {
			throw new InvalidBidException("Bid Must be Higer than current highest Bid "+ currentHighestBid);
		}
		
		bids.put(bid.getUser(),bid.getAmount());
	}

	private double getHighestBid() {
		
		return bids.isEmpty()? 0: Collections.max(bids.values());
	}
	
	public User getHighestBidder() {
		if(bids.isEmpty()) return null;
		
		double highest=getHighestBid();
		for(Map.Entry<User, Double> b: bids.entrySet()) {
			if(b.getValue()==highest) {
				return b.getKey();
			}
		}
		return null;
	}
}

