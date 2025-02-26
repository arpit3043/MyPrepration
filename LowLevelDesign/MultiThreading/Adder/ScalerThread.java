package MultiThreading.Adder;

public class ScalerThread extends Thread {
    private Adder adder;
    public ScalerThread(Adder adder) {
        this.adder = adder;
    }

    @Override
    public void run() {
        adder.run();
    }
}