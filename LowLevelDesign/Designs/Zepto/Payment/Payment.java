package Designs.Zepto.Payment;

public class Payment {
    PaymentMode paymentMode;
 
    public Payment(PaymentMode paymentMode){
        this.paymentMode = paymentMode;
    }
    
    public boolean makePayment(){
        return paymentMode.makePayment();
    }

}
 