package Tries;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.lang.String;

public class PrintAnagrams {
    public static void main(String[] args) throws Exception {
        String[] words = {"act", "god", "cat", "dog", "tac"};
        System.out.println(AnagramsTogether(words));
    }

    private static List<List<String>> AnagramsTogether(String[] string_list) {
        Map<String, List<String>>map = new HashMap<>();
        for(String words: string_list) {
            char[] chars = words.toCharArray();
            Arrays.sort(chars);
            String sorted = Arrays.toString(chars);
            if(!map.containsKey(sorted)) {
                map.put(sorted, new ArrayList<>());
            }
            map.get(sorted).add(words);
        }
        return new ArrayList<>(map.values());
    }
}
