package week01.string.extras;

class ReplaceWord {
    public static void main(String[] args) {
        String sentence = "Java is fun";
        String oldWord = "fun";
        String newWord = "powerful";
        
        String result = "";
        String[] words = sentence.split(" ");
        //Checking and replacing the old with new word 
        for (String word : words) {
            if (word.equals(oldWord)) {
                result += newWord + " ";
            } else {
                result += word + " ";
            }
        }
        //Displaying the result
        System.out.println("Updated Sentence: " + result.trim());
    }
}

