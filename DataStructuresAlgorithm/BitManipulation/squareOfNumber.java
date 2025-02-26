package BitManipulation;
public class squareOfNumber {
    public static void main(String[] args) {
        int N = 3;
        System.out.println(calculateSquare(N));
    }
    private static int calculateSquare(int num) {
        if (num < 0) {
            num = -num;
        }
        return calculateSquareHelperFunction(num);
    }
    private static int calculateSquareHelperFunction(int num) {
        int numSquare = 0;
        int y = num;
        while (y > 0) {
            if ((y & 1) == 1) {
                numSquare = numSquare + num;
            }
            num = num << 1;
            y = y >> 1;
        }
        return numSquare;
    }
}