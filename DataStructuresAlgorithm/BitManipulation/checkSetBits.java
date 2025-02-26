package BitManipulation;
public class checkSetBits {
    public static void main(String[] args) {
        int N = 53;
        System.out.println(checkSetBit(N, 3));
    }

    private static boolean checkSetBit(int N, int i) {
        if ((N^(1<<i))<N) {
            return true;
        }
        return false;
    }
}