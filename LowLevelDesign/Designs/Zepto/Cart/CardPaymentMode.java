package Designs.Zepto.Cart;

import Designs.Zepto.Payment.PaymentMode;

public class CardPaymentMode implements PaymentMode{

    @Override
    public boolean makePayment() {

        return true;
    }
}
