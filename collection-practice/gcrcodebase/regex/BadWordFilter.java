package week04.gcrcodebase.regex;

import java.util.Arrays;
import java.util.List;

public class BadWordFilter {

    public static void main(String[] args) {

        String text = "This is a damn bad example with some stupid words.";

        // List of bad words
        List<String> badWords = Arrays.asList("damn", "stupid");

        // Build regex like: \b(damn|stupid)\b
        String regex = "\\b(" + String.join("|", badWords) + ")\\b";

        String result = text.replaceAll(regex, "****");

        System.out.println(result);
    }
}

