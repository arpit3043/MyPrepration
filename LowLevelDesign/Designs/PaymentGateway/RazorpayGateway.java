package PaymentGateway;

public class RazorpayGateway implements Gateway {
    public boolean makePayment(double amount) {
        System.out.println("Processing payment via Razorpay...");
        return true;
    }
}
