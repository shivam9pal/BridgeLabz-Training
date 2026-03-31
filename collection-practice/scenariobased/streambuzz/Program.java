package week04.scenariobased.streambuzz;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Program {
	
	public static List<CreatorStats> EngagementBoard =new ArrayList<>();
	//
	public void registerCreator(CreatorStats record) {
		EngagementBoard.add(record);
		System.out.println("Creator registered successfully");
	}
	
	
	public Dictionary<String, Integer> getTopPostCounts(List<CreatorStats> records, double likeThreshold){
		
		
		//to store 
		Dictionary<String, Integer> result=new Hashtable<>();
		for(CreatorStats s:records) {
			int count=0;
			for(double likes:s.getWeeklyLikes()) {
				if(likes>=likeThreshold) {
					count++;
				}
			}
			result.put(s.getCreatorName(), count);
		}
		return result;
	}
	
	public double calculateAverageLikes() {
		int totalLike=0;
		int weeks=0;
		for(CreatorStats c: EngagementBoard) {
			weeks++;
			for(double d:c.getWeeklyLikes()) {
				totalLike+=d;
			}
		}
		return totalLike/weeks;
	}
	
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Program program=new Program();
		boolean check=true;
		while(check) {
			System.out.println("Enter your choice");
			System.out.println("1. Register Creator");
			System.out.println("2. Show Top Posts");
			System.out.println("3. Calculate Average Likes");
			System.out.println("4. Exit");
			int userInput=Integer.parseInt(sc.nextLine());
			
			switch (userInput) {
			
				case 1:{
					System.out.println("Enter Creator Name:");
					String creatorName=sc.nextLine();
					System.out.println("Enter weekly likes (Week 1 to 4	):");
					int like1=Integer.parseInt(sc.nextLine());
					int like2=Integer.parseInt(sc.nextLine());
					int like3=Integer.parseInt(sc.nextLine());
					int like4=Integer.parseInt(sc.nextLine());
					
					double[] weekLikes= {like1,like2,like3,like4};
					program.registerCreator(new CreatorStats(creatorName,weekLikes));
					break;
				}
				case 2:{
					System.out.println("Enter like threshold:");
					int threshold=Integer.parseInt(sc.nextLine());
					Dictionary<String, Integer> topPost=program.getTopPostCounts(program.EngagementBoard, threshold);
					if(!topPost.isEmpty()) {
						for(Map.Entry<String, Integer> s:((Hashtable<String, Integer>) topPost).entrySet()) {
							System.out.println(s.getKey()+"-"+s.getValue());
						}
					}else {
						System.out.println("No top-performing post this week");
					}
					break;
				}
				case 3:{
					System.out.println("Overall average weekly likes: "+program.calculateAverageLikes());
					break;
				}
				case 4:{
					check=false;
					break;
				}
			}
		}
		
	}
}
