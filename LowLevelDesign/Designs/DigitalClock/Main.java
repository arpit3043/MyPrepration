package Designs.DigitalClock;

public class Main {
    public static void main(String[] args) throws Exception {
        Clock clock = new Clock(449, 0, 0);

        Thread t1 = new Thread(new ClockPrinter(clock, 0));
        Thread t2 = new Thread(new ClockPrinter(clock, 1));
        Thread t3 = new Thread(new ClockPrinter(clock, 2));

        t1.start();
        t2.start();
        t3.start();
    }
}
