package Structural.CircuitBreaker;
import Structural.CircuitBreaker.Service.RemoteService;
import Structural.CircuitBreaker.Service.RemoteServiceImpl;
import Structural.CircuitBreaker.State.CircuitBreaker;

public class Demo {
    public static void main(String[] args) {
        CircuitBreaker circuitBreaker = new CircuitBreaker(3, 5000);
        RemoteService service = new RemoteServiceImpl();

        for (int i = 0; i < 10; i++) {
            try {
                String response = circuitBreaker.call(service);
                System.out.println(response);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ignored) {}
        }
    }
}
