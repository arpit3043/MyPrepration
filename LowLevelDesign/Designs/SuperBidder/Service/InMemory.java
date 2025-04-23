package Designs.SuperBidder.Service;

import Designs.SuperBidder.Repository.AuctionRepository;
import Designs.SuperBidder.Repository.BuyerRepository;
import Designs.SuperBidder.Repository.SellerRepository;

public class InMemory {
    public static SellerRepository sellerRepository;
    public static BuyerRepository buyerRepository;
    public static AuctionRepository auctionRepository;
    public InMemory() {
        sellerRepository=new SellerRepository();
        buyerRepository=new BuyerRepository();
        auctionRepository=new AuctionRepository();
    }
}
