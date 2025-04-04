package Hashing.HashMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class SortCharactersByFrequency {
    public static void main(String[] args) {
        String s = "raaaajji";
        System.out.println(frequencySort(s));
    }

    private static List<Character> frequencySort(String s) {
        Map<Character, Integer> charFrequencies = new HashMap<>();

        for (char c : s.toCharArray()) {
            charFrequencies.put(c, charFrequencies.getOrDefault(c, 0) + 1);
        }

        List<Character> characters = new ArrayList<>(charFrequencies.keySet());

        Collections.sort(characters, (a, b) -> {
            int freqComparison = charFrequencies.get(b).compareTo(charFrequencies.get(a));
            if (freqComparison == 0) {
                return a.compareTo(b);
            }
            return freqComparison;
        });

        return characters;
    }
}
