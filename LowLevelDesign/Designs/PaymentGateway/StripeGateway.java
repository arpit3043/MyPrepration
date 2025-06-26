package PaymentGateway;

public class StripeGateway implements Gateway {
    public boolean makePayment(double amount) {
        System.out.println("Processing payment via Stripe...");
        return true;
    }
}
// Compare this snippet from LowLevelDesign/Designs/PaymentGateway/PaymentProcessor.java: