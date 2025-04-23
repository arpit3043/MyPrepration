package Designs.SuperBidder.Utils;

import java.util.List;

import Designs.SuperBidder.DataTransmissionObject.Seller;

public class SellerUtil {
    public static Seller getSellerByName(String sellerName, List<Seller> sellerList){
        for (int i=0;i<sellerList.size();i++){
            if (sellerList.get(i).getName().equals(sellerName)) {
                Seller seller = sellerList.get(i);
                return seller;
            }
        }
        throw new RuntimeException("Invalid Seller");
    }

}