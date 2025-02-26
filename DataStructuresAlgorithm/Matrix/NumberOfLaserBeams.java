package Matrix;
import java.lang.String;
public class NumberOfLaserBeams {
    public static void main(String[] args) throws Exception {
        String[] bank = {"011001","000000","010100","001000"};
        System.out.println(numberOfBeams(bank));
    }
    private static int numberOfBeams(String[] bank) {
        int N=bank.length;
        int prevRowCount = 0;
        int total=0;
        for (String s : bank) {
            int curRowCount = calculate(s);
            if (curRowCount == 0) {
                continue;
            }
            total = total + (curRowCount * prevRowCount);
            prevRowCount = curRowCount;
        }
        return total;
    }
    private static int calculate(String s) {
        int count = 0;
        for(char c : s.toCharArray()) {
            count = count + c - '0';
        }
        return count;
    }
}