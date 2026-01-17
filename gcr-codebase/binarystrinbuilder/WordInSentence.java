package week03.gcrcodebase.binarystrinbuilder;

class WordInSentence {

	public static String findSentenceWithWord(String[] sentences, String word) {
        for (String sentence : sentences) {
            if (sentence.toLowerCase().contains(word.toLowerCase())) {
                return sentence; 
            }
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        String[] sentences = {
            "Java is a robust  language.",
            "Java is important for efficiency.",
            "Linear search is simple and effective.",
            "Algorithm make problem solving easier."
        };

        String wordToFind = "search";

        String result = findSentenceWithWord(sentences, wordToFind);

        if (!result.equals("Not Found")) {
            System.out.println("Sentence found:");
            System.out.println(result);
        } else {
            System.out.println("Not Found");
        }
    }
}
