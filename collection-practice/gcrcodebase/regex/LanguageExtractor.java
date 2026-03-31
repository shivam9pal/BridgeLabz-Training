package week04.gcrcodebase.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LanguageExtractor {

    public static void main(String[] args) {

        String text = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";

        String regex = "\\b[A-Z][a-zA-Z]*\\b";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}

