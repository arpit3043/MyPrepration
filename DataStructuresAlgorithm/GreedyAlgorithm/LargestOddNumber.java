package GreedyAlgorithm;
public class LargestOddNumber {
    public static void main(String[] args) throws Exception {
       String str="35427";
        System.out.println(largestOddNumber(str));
    }
    private static String largestOddNumber(String num) {
        int N = num.length();
        for(int i=N-1; i>=0; i--) {
            char c = num.charAt(i);
            if(checkOddNum(c)) {
                return num.substring(0, i+1);
            }
        }
        return "";
    }
    private static boolean checkOddNum(int N) {
        return (N % 2 != 0);
    }
}