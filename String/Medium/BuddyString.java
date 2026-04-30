public class BuddyString {
    public boolean buddyStrings(String s, String goal) {
        int m = s.length();
        int n = goal.length();
        if (m != n) return false;

        int[] count1 = new int[26];
        int[] count2 = new int[26];
        int diff = 0;

        for (int i = 0; i < n; i++) {
            count1[s.charAt(i) - 'a']++;
            count2[goal.charAt(i) - 'a']++;
            if (s.charAt(i) != goal.charAt(i)) diff++;
        }

        boolean hasDuplicate = false;
        for (int i = 0; i < 26; i++) {
            if (count1[i] != count2[i]) return false;
            if (count1[i] > 1) hasDuplicate = true;
        }

        return (diff == 2) || (diff == 0 && hasDuplicate);
    }
}
