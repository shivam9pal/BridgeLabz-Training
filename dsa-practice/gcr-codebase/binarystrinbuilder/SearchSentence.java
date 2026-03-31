package week03.gcrcodebase.binarystrinbuilder;

class SearchSentence {

    static String findSentence(String[] sentences, String word) {
        for (String s : sentences) {
            if (s.contains(word)) {
                return s;   
            }
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        String[] sentences = {
            "Java is a powerful language","Spring Boot makes development easy","Docker helps in deployment","Kubernetes manages containers"
        };

        String word = "Docker";

        String result = findSentence(sentences, word);
        System.out.println(result);
    }
}

