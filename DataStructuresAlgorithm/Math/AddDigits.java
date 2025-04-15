package Math;

public class AddDigits {
    public static void main(String[] args) {
        int num = 38;
        System.out.println("The result is: " + addDigits(num));
    }

    private static int addDigits(int num) {
        if(num==0) {
            return 0;
        } else if(num%9==0) {
            return 9;
        } else {
            return num%9;
        }
    }
}