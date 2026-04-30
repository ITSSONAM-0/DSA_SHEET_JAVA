public class PermutationinString {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> hp1 = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            hp1.put(ch, hp1.getOrDefault(ch, 0) + 1);
        }

        int n = s1.length();

        for (int f = 0; f <= s2.length() - n; f++) {
            HashMap<Character, Integer> hp2 = new HashMap<>();

            for (int i = f; i < f + n; i++) {
                char ch = s2.charAt(i);
                hp2.put(ch, hp2.getOrDefault(ch, 0) + 1);
            }

            if (hp1.equals(hp2)) {
                return true;
            }
        }

        return false;
    }
}
