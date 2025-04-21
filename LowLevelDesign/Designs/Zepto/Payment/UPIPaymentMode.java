package Designs.Zepto.Payment;

public class UPIPaymentMode implements PaymentMode{

    @Override
    public boolean makePayment() {
        return true;
    }
}
