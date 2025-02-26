package LamdasAndStreams;

public class Main {
    public static void main(String[] args) {
        // Lambdas l = new Lambdas();
        Runnable l = new Lambdas();
        Thread t = new Thread(l);
        t.start();
        Runnable r = ()-> {
            System.out.println("Inside Lambdas Expression Main Class");
        };
        Thread t2 = new Thread(r);
        t2.start();
        Runnable r1 = ()-> System.out.println("Inside Lambdas Expression Main Class without {}");
        Thread t3 = new Thread(r1);
        t3.start();
    }
}
