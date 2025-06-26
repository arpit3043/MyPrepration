package PaymentGateway;

public class GatewayFactory {
    public static Gateway getGateway(String type) {
        if ("razorpay".equalsIgnoreCase(type)) {
            return new RazorpayGateway();
        } else if ("stripe".equalsIgnoreCase(type)) {
            return new StripeGateway();
        }
        throw new IllegalArgumentException("Unsupported gateway type");
    }
}
