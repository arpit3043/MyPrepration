package TwoPointers;
import java.util.Arrays;
import java.lang.String;
public class AssignCookies {
    public static void main(String[] args) {
        int[] g = {1,2,3};
        int[] s = {1,1};
        System.out.println(findCookiesContentForChildren(g,s));
    }
    private static int findCookiesContentForChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gPointer=0;
        int sPointer=0;
        if(s.length == 0) {
            return 0;
        }
        while(gPointer < g.length && sPointer < s.length) {
            if(g[gPointer] <= s[sPointer]) {
                gPointer++;
                sPointer++;
            } else {
                sPointer++;
            }
        }
        return gPointer;
    }
}