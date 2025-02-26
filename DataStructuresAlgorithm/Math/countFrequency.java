package Math;
import java.util.Scanner;
public class countFrequency {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int d = scn.nextInt();
        int f = getDigitFrequency(n, d);
        System.out.println(f);
    }
    private static int getDigitFrequency(int n, int d) {
        int count = 0;
        while(n>0) {
            int temp = n%10;
            if(temp==d) {
                count++;
            }
            n = n/10;
        }
        return count;
    }
}