package String;
import java.util.HashMap;
import java.util.Map;
import java.lang.String;
import java.lang.Integer;
import java.lang.Character;
public class MinimumOpsToMakeEqualStrings {
    public static void main(String[] args) throws Exception {
        String a="abacaba";
        String b="bacabaa";
        System.out.println(minimumOperationsToMakeTwoStringsEqual(a,b));
    }
    private static int minimumOperationsToMakeTwoStringsEqual(String a, String b) {
        int n=a.length();
        int m=b.length();
        int count=0;
        if(n!=m) {
            return -1;
        }
        if(n==1) {
            if(a.charAt(0)==b.charAt(0)) {
                return 0;
            } else {
                return 1;
            }
        }
        for(int i=0; i<n/2; i++) {
            Map<Character,Integer> map=new HashMap<>();
            map.put(a.charAt(i),map.getOrDefault(a.charAt(i),0)+1);
            map.put(a.charAt(n-i-1),map.getOrDefault(a.charAt(n-i-1),0)+1);
            map.put(b.charAt(i),map.getOrDefault(b.charAt(i),0)+1);
            map.put(b.charAt(n-i-1),map.getOrDefault(b.charAt(n-i-1),0)+1);
            if(map.size()==4) {
                count=count+2;
            }
            else if(map.size()==3) {
                if(a.charAt(i)==a.charAt(n-i-1)) {
                    count=count+2;
                } else {
                    count++;
                }
            }
            else if(map.size()==2) {
                int c=0;
                for(int value:map.values()) {
                    c=value;
                    break;
                }
                if(c%2!=0) {
                    count++;
                }
            }
        }
        if(n%2!=0) {
            if(a.charAt(n/2)!=b.charAt(n/2)) {
                count++;
            }
        }
        return count;
    }
}
