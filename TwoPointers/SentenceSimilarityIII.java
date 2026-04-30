package DSA_SHEET_JAVA.TwoPointers;

public class SentenceSimilarityIII {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] words1 = sentence1.split(" ");
        String[] words2 = sentence2.split(" ");

        if (words1.length < words2.length) {
            String[] temp = words1;
            words1 = words2;
            words2 = temp;
        }

        int i = 0;
        int j = words2.length - 1;
        int end = words1.length - 1;

        while (i < words2.length && words1[i].equals(words2[i])) {
            i++;
        }

        while (j >= i && words1[end].equals(words2[j])) {
            end--;
            j--;
        }

        return j < i;
    }
}
