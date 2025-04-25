package DataStructuresAlgorithm.BackTracking;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class LetterCombination {
    public static void main(String[] args) {
        String digits = "23";
        System.out.println(letterCombinations(digits));
    }

    private static List<String> letterCombinations(String digits) {
        int N = digits.length();
        List<String> output = new ArrayList<>();

        // Keypad mapping as per digit to character
        List<String> keypad = Arrays.asList(
            "", "", "abc", "def", "ghi",
            "jkl", "mno", "pqrs", "tuv", "wxyz"
        );

        // If input is empty, return empty list
        if (N == 0) {
            return new ArrayList<>();
        }

        // Start recursive helper with empty temp string
        letterCombinationsHelper(digits, "", keypad, output, 0, N);
        return output;
    }

    // Recursive helper method
    private static void letterCombinationsHelper(String digits, String temp, List<String> keypad, List<String> output, int start, int end) {
        // Base case: if we've formed a string of required length, add to output
        if (start >= end) {
            output.add(temp); // Add formed string to the list
            return;
        }

        // Get the characters mapped to current digit
        // Loop through each character and recursively build the string
        for (int i = 0; i < keypad.get(digits.charAt(start) - '0').length(); i++) {
            char ch = keypad.get(digits.charAt(start) - '0').charAt(i);
            // Add character to temp and recurse for next digit
            letterCombinationsHelper(digits, temp + ch, keypad, output, start + 1, end);
            // No need to explicitly remove the last character (backtrack) since `temp + ch` creates a new string each time
        }
    }
}