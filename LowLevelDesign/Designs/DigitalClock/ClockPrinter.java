package Designs.DigitalClock;

public class ClockPrinter implements Runnable {
    private Clock clock;
    private int threadId;

    public ClockPrinter(Clock clock, int threadId) {
        this.clock = clock;
        this.threadId = threadId;
    }

    @Override
    public void run() {
        while(true) {
            clock.tick(threadId);
        }
    }
}