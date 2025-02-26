package BackTracking;
import java.util.ArrayList;
public class LetterCombinationPhoneNumber {
    public static void main(String[] args) {
        String s = "23";
        System.out.println(combinations(s));
    }
    private static ArrayList<String> combinations(String s) {
        ArrayList<String> ans = new ArrayList<>();
        StringBuilder output = new StringBuilder();
        if(s.isEmpty()) {
            return ans;
        }
        String[] mapping = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        int index = 0;
        combinationsHelper(s, ans, output, mapping, index);
        return ans;
    }
    private static void combinationsHelper(String s, ArrayList<String> ans,
                                           StringBuilder output, String[] mapping, int index){
        if(index >= s.length()) {
            ans.add(output.toString());
            return;
        }
        int number = s.charAt(index) - '0';
        String value = mapping[number];
        for (int i = 0; i < value.length(); i++) {
            output.append(value.charAt(i));
            combinationsHelper(s, ans, output, mapping, index+1);
            output.deleteCharAt(output.length()-1);
        }
    }
}
