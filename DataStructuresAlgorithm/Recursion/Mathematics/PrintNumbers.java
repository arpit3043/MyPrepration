package Recursion.Mathematics;

public class PrintNumbers {
    public static void main(String[] args) {
        int n = 10;
        printNos(n);
    }

    private static void printNos(int n) {
        printNosHelper(n);
    }

    private static void printNosHelper(int n) {
        if(n==0) {
            return;
        }
        printNosHelper(n-1);
        System.out.print(n + " ");
    }
}
