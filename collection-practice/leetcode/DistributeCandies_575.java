package week_4;
import java.util.*;
public class DistributeCandies_575 {
	public int distributeCandies(int[] candyType) {
        return Math.min(candyType.length / 2,
                       new HashSet<Integer>(Arrays.stream(candyType).boxed().toList()).size());
   }
	public static void main(String[] args) {
		DistributeCandies_575 obj = new DistributeCandies_575();
		int[] candyType = { 1, 1, 2, 2, 3, 3 };
		System.out.println(obj.distributeCandies(candyType));
	}
}
