package week04.gcrcodebase.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class LinkExtractor {

    public static void main(String[] args) {

        String text = "Visit https://www.google.com and http://example.org for more info.";

        String regex = "https?://\\S+";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
