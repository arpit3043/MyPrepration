package BitManipulation;
public class SwapNumbers {
    public static void main(String[] args) {
        int a=2;
        int b=3;
        System.out.println("The numbers 'a' & 'b' before swapping are: "+a+" "+b + " respectively.");
        swapNumbers(a,b);
        System.out.println("The numbers 'a' & 'b' before swapping are: "+a+" "+b + " respectively.");
    }

    private static void swapNumbers(int x, int y) {
        if (x != y) {
            x = x ^ y;
            y = x ^ y;
            x = x ^ y;
        }
    }
}