package String;
/**
 * Given a list of strings, find and group together all the strings that are buddies with one another.
 * You may use any data structure but you're choosing to return the grouping of buddies.
 * Two strings are buddies if they are of same length and the characters are equal distance from each other. 
 * For example, AAA and ZZZ are buddies but AAA would not be buddies with ABC.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.lang.String;

public class BuddyStrings {
    // Disjoint Set Union class
    static class DSU {
        int[] parent;
        DSU(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        int find(int x) {
            if (x != parent[x])
                parent[x] = find(parent[x]);
            return parent[x];
        }

        void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px != py) {
                parent[py] = px;
            }
        }
    }

    public static void main(String[] args) {
        List<String> words = Arrays.asList("AAA", "ZZZ", "ABC", "WXY", "ABD");
        List<List<String>> result = groupBuddiesByDSU(words);
        for (List<String> group : result) {
            System.out.println(group);
        }
    }

    public static List<List<String>> groupBuddiesByMap(List<String> words) {
        Map<String, List<String>> groups = new HashMap<>();
        for (String word : words) {
            if (word.isEmpty()) {
                continue;
            }
            String key = getShiftPattern(word);
            if (!groups.containsKey(key)) {
                groups.put(key, new ArrayList<>());
            }
            groups.get(key).add(word);
            // groups.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
        }
        return new ArrayList<>(groups.values());
    }

    private static String getShiftPattern(String word) {
        if (word.length() == 1) {
            return "single";
        }
        int[] shifts = new int[word.length() - 1];
        for (int i = 1; i < word.length(); i++) {
            shifts[i - 1] = (word.charAt(i) - word.charAt(i - 1) + 26) % 26;
        }
        return Arrays.toString(shifts);
    }

    public static List<List<String>> groupBuddiesByDSU(List<String> words) {
        int n = words.size();
        DSU dsu = new DSU(n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (areBuddies(words.get(i), words.get(j))) {
                    dsu.union(i, j);
                }
            }
        }

        // Map from parent to list of strings
        Map<Integer, List<String>> groups = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int parent = dsu.find(i);
            groups.computeIfAbsent(parent, k -> new ArrayList<>()).add(words.get(i));
        }

        return new ArrayList<>(groups.values());
    }

    // Buddy check logic
    private static boolean areBuddies(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        int diff = ((b.charAt(0) - a.charAt(0)) + 26) % 26;
        for (int i = 1; i < a.length(); i++) {
            int currDiff = ((b.charAt(i) - a.charAt(i)) + 26) % 26;
            if (currDiff != diff) return false;
        }
        return true;
    }
}