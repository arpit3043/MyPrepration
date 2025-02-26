package Structural.CircuitBreaker.Service;

public class RemoteServiceImpl implements RemoteService {
    @Override
    public String callService() {
        if (Math.random() < 0.5) {
            throw new RuntimeException("Service failure");
        }
        return "Service call successful";
    }
}
