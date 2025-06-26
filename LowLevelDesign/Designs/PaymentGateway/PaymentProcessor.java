package PaymentGateway;

public class PaymentProcessor {
    private Gateway gateway;

    public PaymentProcessor(Gateway gateway) {
        this.gateway = gateway;
    }

    public void processPayment(double amount) {
        gateway.makePayment(amount);
    }
}
