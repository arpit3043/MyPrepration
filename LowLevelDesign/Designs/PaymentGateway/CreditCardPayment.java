package PaymentGateway;

public class CreditCardPayment implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Paid using Credit Card: " + amount);
    }
}