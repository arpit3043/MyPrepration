package Designs.SuperBidder.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Designs.SuperBidder.DataTransmissionObject.Auction;
import Designs.SuperBidder.DataTransmissionObject.Seller;

public class SellerRepository {
   static List<Seller> sellerList;
   static Map<String, Auction> sellerAuctionMap;

    public SellerRepository() {
        sellerList = new ArrayList<>();;
        sellerAuctionMap =new HashMap<>();
    }

    public static List<Seller> getSellerList() {
        return sellerList;
    }
    
    public static Map<String, Auction> getSellerAuctionMap() {
        return sellerAuctionMap;
    }

}