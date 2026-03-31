package collectors;

import java.util.*;
import java.util.stream.Collectors;

public class WordOccurrenceAnalyzer {

	public static void main(String[] args) {

		String paragraph = "Java streams make Java code concise and streams make code readable";

		Map<String, Integer> wordCount = Arrays.stream(paragraph.toLowerCase().split("\\s+"))
				.collect(Collectors.toMap(word -> word, word -> 1, Integer::sum));

		wordCount.forEach((word, count) -> System.out.println(word + " → " + count));
	}
}
