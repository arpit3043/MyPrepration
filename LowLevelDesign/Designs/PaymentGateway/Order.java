package PaymentGateway;

// This class implements the PaymentStrategy interface and provides an implementation for credit card payments.
public class Order {
    private double amount;
    private PaymentStrategy paymentStrategy;

    public Order(double amount) {
        this.amount = amount;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void processOrder() {
        paymentStrategy.pay(amount);
    }
}

