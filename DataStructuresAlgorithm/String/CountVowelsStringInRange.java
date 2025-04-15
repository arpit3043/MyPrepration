package String;

import java.util.Arrays;
import java.lang.String;
import java.lang.Exception;

public class CountVowelsStringInRange {

    public static void main(String[] args) throws Exception {
        String[] words = {"aba","bcb","ece","aa","e"};
        int[][] queries = {
            {0, 2},
            {1, 4},
            {1, 1}
        };

        System.out.println(Arrays.toString(vowelStrings(words, queries)));
    }

    private static int[] vowelStrings(String[] words, int[][] queries) {
        int index = 0;
        int n = words.length;
        int q = queries.length;
        int[] ans = new int[q];
        int[] prefixArray = new int[n];

        for(int i=0; i<n; i++) {
            String temp = words[i];
            if(isVowel(temp.charAt(0)) && isVowel(temp.charAt(temp.length()-1))) {
                prefixArray[i]++;
            }
        }

        for(int i=1; i<n; i++) {
            prefixArray[i] = prefixArray[i] + prefixArray[i-1];
        }

        for(int i=0; i<q; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            if(start == 0) {
                ans[index] = prefixArray[end];
                index++;
            } else {
                ans[index] = prefixArray[end] - prefixArray[start-1];
                index++;
            }
        }
        return ans;
    }

    private static boolean isVowel(char ch) {
        String str = "aeiou";
        if(str.indexOf(ch)!=-1) {
            return true;
        }
        return false;
    }
}