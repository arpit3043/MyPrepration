package BitManipulation;
public class OddRecurringElement {
    public static void main(String[] args) {
        int[] arr = { 4, 3, 6, 2, 6, 4, 2, 3, 4, 3, 3 };
        System.out.println("The odd occurring element is " + findOddOccuring(arr));
    }
    private static int findOddOccuring(int[] arr) {
        int xor = 0;
        for (int i: arr) {
            xor = xor ^ i;
        }
        return xor;
    }
}
