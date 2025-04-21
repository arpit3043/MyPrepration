package Designs.Zepto.Order;

import java.util.Map;

import Designs.Zepto.Address;
import Designs.Zepto.Invoice;
import Designs.Zepto.Payment.Payment;
import Designs.Zepto.Payment.PaymentMode;
import Designs.Zepto.Payment.UPIPaymentMode;
import Designs.Zepto.User.User;
import Designs.Zepto.Warehouse.Warehouse;

public class Order {

    User user;
    Address deliveryAddress;
    Map<Integer, Integer> productCategoryAndCountMap;
    Warehouse warehouse;
    Invoice invoice;
    Payment payment;
    OrderStatus orderStatus;

    Order(User user, Warehouse warehouse){
        this.user = user;
        this.productCategoryAndCountMap = user.getUserCart().getCartItems();
        this.warehouse = warehouse;
        this.deliveryAddress = user.address;
        invoice = new Invoice();
        invoice.generateInvoice(this);
    }

    public void checkout(){

        //1. update inventory
        warehouse.removeItemFromInventory(productCategoryAndCountMap);

        //2. make Payment
        boolean isPaymentSuccess = makePayment(new UPIPaymentMode());

        //3. make cart empty
        if(isPaymentSuccess) {
            user.getUserCart().emptyCart();
        }
        else{
            warehouse.addItemToInventory(productCategoryAndCountMap);
        }

    }

    public boolean makePayment(PaymentMode paymentMode){
        payment = new Payment(paymentMode);
       return payment.makePayment();
    }

    public void generateOrderInvoice(){
        invoice.generateInvoice(this);
    }
}
