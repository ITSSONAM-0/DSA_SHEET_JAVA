package DSA_SHEET_JAVA.Graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadder {
    public List<String> getn(String word, HashSet<String> set) {
        List<String> n = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (ch == word.charAt(i)) {
                    continue;
                }
                String newWord = word.substring(0, i) + ch + word.substring(i + 1, word.length());
                if (set.contains(newWord)) {
                    n.add(newWord);
                }
            }
        }
        return n;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        if (set.contains(beginWord)) {
            set.remove(beginWord);
        }

        int level = 0;

        while (!queue.isEmpty()) {
            int cursize = queue.size();

            for (int i = 0; i < cursize; i++) {
                String node = queue.poll();
                if (node.equals(endWord)) {
                    return level + 1;
                }

                List<String> n = getn(node, set);
                for (String word : n) {
                    if (set.contains(word)) {
                        queue.offer(word);
                        set.remove(word);
                    }
                }
            }
            level++;
        }

        return 0;
    }
}
