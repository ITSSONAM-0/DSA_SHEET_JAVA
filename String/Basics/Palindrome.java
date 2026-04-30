package String.Basics;

public class Palindrome {
    public boolean isPalindrome(String s) {
        // Convert the string to lowercase and remove non-alphanumeric characters
        String cleanedString = s.toLowerCase().replaceAll("[^a-z0-9]", "");

        // Check if the cleaned string is a palindrome
        int left = 0;
        int right = cleanedString.length() - 1;
        while (left < right) {
            if (cleanedString.charAt(left) != cleanedString.charAt(right)) {
                return false; // Characters don't match, not a palindrome
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome();
        
        // Test cases
        String[] testStrings = {"A man, a plan, a canal, Panama", "racecar", "hello", "Was it a car or a cat I saw?"};
        
        for (String testString : testStrings) {
            System.out.println("Is \"" + testString + "\" a palindrome? " + palindrome.isPalindrome(testString));
        }
    }
}
