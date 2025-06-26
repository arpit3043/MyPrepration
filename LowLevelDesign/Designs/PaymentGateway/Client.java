package PaymentGateway;

public class Client {
    public static void main(String[] args) {
        // Strategy usage
        Order order = new Order(500.00);
        order.setPaymentStrategy(new CreditCardPayment());
        order.processOrder();

        // Factory + Strategy
        Gateway gateway = GatewayFactory.getGateway("stripe");
        PaymentProcessor processor = new PaymentProcessor(gateway);
        processor.processPayment(500.00);
    }
}