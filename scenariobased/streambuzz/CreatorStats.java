package week04.scenariobased.streambuzz;

class CreatorStats {
	private String creatorName;
	private double[] weeklyLikes;
	
	public CreatorStats(String name,double[] likes) {
		this.creatorName=name;
		this.weeklyLikes=likes;
	}

	public String getCreatorName() {
		return creatorName;
	}

	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}

	public double[] getWeeklyLikes() {
		return weeklyLikes;
	}

	public void setWeeklyLikes(double[] weeklyLikes) {
		this.weeklyLikes = weeklyLikes;
	}
	
	
}
