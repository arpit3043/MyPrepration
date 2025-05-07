package Designs.DigitalClock;

public class Clock {
    private int hour;
    private int minute;
    private int second;
    
    public Clock(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }
    
    public synchronized void tick(int threadId) {
        while(threadId != turn) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        System.out.printf("%03d:%02d:%02d", hour, minute, second);
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        second++;
        if(second == 60) {
            second = 0;
            minute++;
        }
        
        if(minute == 60) {
            minute = 0;
            hour++;
        }
        
        turn = (turn+1)%3;
        notifyAll();
    }
}
