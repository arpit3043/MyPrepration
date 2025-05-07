package Tries;

import java.util.ArrayList;
import java.util.List;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }

    // Time Complexity: O(N * K), where N is the number of strings and K is the maximum length of a string.
    // Space Complexity: O(N * K), where N is the number of strings and K is the maximum length of a string.
    private static List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        List<List<String>> ans = new ArrayList<>();
        boolean[] visited = new boolean[n];
        if (n == 0) {
            return ans;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            List<String> group = new ArrayList<>();
            group.add(strs[i]);
            visited[i] = true;
            for (int j = i + 1; j < n; j++) {
                if (!visited[j] && isValidAnagram(strs[i], strs[j])) {
                    group.add(strs[j]);
                    visited[j] = true;
                }
            }
            ans.add(group);
        }
        return ans;
    }

    // Time Complexity: O(N * K), where N is the number of strings and K is the maximum length of a string.
    // Space Complexity: O(1), as we are using a constant space for the count array.
    private static boolean isValidAnagram(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[] count = new int[26];
        if (n == 0 && m == 0) {
            return true;
        }

        if (n != m) {
            return false;
        }

        for (char c : s1.toCharArray()) {
            count[c - 'a']++;
        }

        for (char c : s2.toCharArray()) {
            count[c - 'a']--;
        }

        for (int val : count) {
            if (val != 0) {
                return false;
            }
        }
        return true;
    }
}
// Overall Time Complexity: O(N * K), where N is the number of strings and K is the maximum length of a string.
// Overall Space Complexity: O(N * K), where N is the number of strings and K is the maximum length of a string.
