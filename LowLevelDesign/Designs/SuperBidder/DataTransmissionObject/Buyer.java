package Designs.SuperBidder.DataTransmissionObject;
import java.util.List;

public class Buyer {
    String name;
    List<Auction> auctionList;

    public Buyer(String name, List<Auction> auctionList) {
        this.name = name;
        this.auctionList = auctionList;
    }


}