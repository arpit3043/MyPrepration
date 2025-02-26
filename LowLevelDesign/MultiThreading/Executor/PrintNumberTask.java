public class PrintNumberTask implements Runnable {
    private Integer noToPrint;
    public PrintNumberTask(Integer x) {
        noToPrint=x;
    }
    @Override
    public void run() {
        System.out.println("Number is:  " + noToPrint +
        " Name of Thread is:  "
        + Thread.currentThread().getName());
    }
}