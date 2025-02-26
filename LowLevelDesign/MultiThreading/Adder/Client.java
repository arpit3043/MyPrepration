package MultiThreading.Adder;
import java.util.Scanner;
import java.lang.String;
public class Client {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        Adder adder = new Adder(a, b);
        ScalerThread adderThread = new ScalerThread(adder);
        adderThread.start();
    }
}