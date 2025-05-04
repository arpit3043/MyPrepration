package AND;
import java.util.Scanner;
class CheckSetBit{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(checkSetBit(a, b));
        sc.close();
    }

    private static boolean checkSetBit(int a, int b) {
        if((a & (1<<b))==0) {
            return false;
        }
        return true;
    }
}