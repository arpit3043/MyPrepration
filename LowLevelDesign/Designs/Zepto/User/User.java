package Designs.Zepto.User;

import java.util.ArrayList;
import java.util.List;

import Designs.Zepto.Address;
import Designs.Zepto.Cart.Cart;

public class User {

    public int userId;
    String userName;
    public Address address;
    Cart userCartDetails;
    List<Integer> orderIds;

    public User(){
        userCartDetails = new Cart();
        orderIds = new ArrayList<>();
    }

    //get UserCart
    public Cart getUserCart(){
        return userCartDetails;
    }
}
