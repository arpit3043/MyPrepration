package String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.lang.String;
import java.lang.Integer;
public class SubStringAfterWordsConcatination {
    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = {"foo","bar"};
        System.out.println(findSubstringAfterWordsConcatination(s, words));
    }
    private static List<Integer> findSubstringAfterWordsConcatination(String s, String[] words) {
        int k=words.length * words[0].length();
        int ws=0;
        int we=0;
        List<Integer> ans=new ArrayList<>();
        StringBuilder str=new StringBuilder();
        while(we<s.length()){
            str.append(s.charAt(we));
            if(str.length()==k){
                if(isValid(str.toString(),words)){
                    ans.add(ws);
                }
                str.delete(0,1);
                ws+=1;
            }
            we++;
        }
        return ans;
    }

    private static boolean isValid(String s,String[] words){
        int l=words[0].length();
        Map<String, Integer> count=new HashMap<>();
        for (String word : words) {
            count.put(word,count.getOrDefault(word, 0) + 1);
        }
        for (int i=0;i<s.length();i+=l) {
            String sub = s.substring(i,i+l);
            if (!count.containsKey(sub) || count.get(sub) <= 0) {
                return false;
            }
            count.put(sub,count.get(sub)-1);
        }
        return true;
    }
}