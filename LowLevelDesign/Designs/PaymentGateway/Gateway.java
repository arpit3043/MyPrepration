package PaymentGateway;

public interface Gateway {
    boolean makePayment(double amount);
}