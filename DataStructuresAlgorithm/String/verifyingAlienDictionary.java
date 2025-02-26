package String;
import java.io.IOException;
import java.lang.String;
public class verifyingAlienDictionary {
    public static void main(String[] args) throws Exception, IOException {
        String order = "worldabcefghijkmnpqstuvxyz";
        String[] words = {"word", "world", "row"};
        int N = words.length;
        if(IsAlienDictonary(N, words, order)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    private static Boolean IsAlienDictonary(int n, String[] words, String order) {
        for(int i = 1; i < n ;i++){
            if(!(isGreaterThan(words[i], words[i -1], order))){
                return false;
            }
        }
        return true;
    }

    private static boolean isGreaterThan(String s1, String s2, String order){
        int i = 0;
        int n1=s1.length();
        int n2=s2.length();
        while(i < Math.min(n1, n2) && s1.charAt(i) == s2.charAt(i)) {
            i++;
        }
        if(n2 == i) {
            return true;
        }
        if(n1 == i) {
            return false;
        }
        if(order.indexOf(s1.charAt(i)) >= order.indexOf(s2.charAt(i))) {
            return true;
        }
        return false;
    }
}