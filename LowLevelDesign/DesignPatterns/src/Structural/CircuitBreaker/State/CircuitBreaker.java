package Structural.CircuitBreaker.State;

import Structural.CircuitBreaker.Service.RemoteService;

public class CircuitBreaker {

    private final int failureThreshold;
    private final long retryTimePeriod;
    private int failureCount;
    private long lastFailureTime;
    private CircuitBreakerState state;

    public CircuitBreaker(int failureThreshold, long retryTimePeriod) {
        this.failureThreshold = failureThreshold;
        this.retryTimePeriod = retryTimePeriod;
        this.state = CircuitBreakerState.CLOSED;
    }

    public String call(RemoteService service) throws Exception {
        if (state == CircuitBreakerState.OPEN) {
            if (System.currentTimeMillis() - lastFailureTime > retryTimePeriod) {
                state = CircuitBreakerState.HALF_OPEN;
            } else {
                throw new Exception("Circuit is open, please try later");
            }
        }

        try {
            String response = service.callService();
            reset();
            return response;
        } catch (Exception e) {
            recordFailure();
            if (failureCount >= failureThreshold) {
                state = CircuitBreakerState.OPEN;
                lastFailureTime = System.currentTimeMillis();
            }
            throw new Exception("Service call failed");
        }
    }

    private void reset() {
        state = CircuitBreakerState.CLOSED;
        failureCount = 0;
    }

    private void recordFailure() {
        failureCount++;
    }
}
