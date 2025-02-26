package String;
import java.lang.String;
public class BeautifulString {
    public static void main(String[] args) {
        String str = "1010";
        System.out.println(makeBeautiful(str));
    }
    private static int makeBeautiful(String str) {
        int N = str.length();
        int count0=0;
        int count1=0;
        for(int i=0; i<N; i++) {
            if(i%2==0) {
                if(str.charAt(i)=='1') {
                    count0++;
                } else {
                    count1++;
                }
            } else {
                if(str.charAt(i)=='1') {
                    count1++;
                } else {
                    count0++;
                }
            }
        }
        return Math.min(count0, count1);
    }
}