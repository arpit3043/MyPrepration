package Designs.SuperBidder.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import Designs.SuperBidder.DataTransmissionObject.Auction;
import Designs.SuperBidder.DataTransmissionObject.Seller;
import Designs.SuperBidder.Repository.SellerRepository;
import Designs.SuperBidder.Repository.AuctionRepository;

public class SellerService {

    List<Seller> sellerList = SellerRepository.getSellerList();
    List<Auction> auctionList = AuctionRepository.getAuctionList();
    Map<String, Auction> sellerAuctionMap = SellerRepository.getSellerAuctionMap();

    public void addSeller(String sellerName) {
        Seller seller = new Seller(sellerName, new ArrayList<>());
        sellerList.add(seller);
    }

    public void createAuction(String auctionName, int minBid, int maxBid, String sellerName) {
        Seller seller = getSellerByName(sellerName);
        if (seller == null) {
            throw new RuntimeException("Invalid Seller");
        }

        Auction auction = new Auction(auctionName, minBid, maxBid, sellerName, true);
        seller.getAuctionList().add(auction);
        auctionList.add(auction);
        sellerAuctionMap.put(sellerName, auction);
    }

    public void closeAuction(String auctionName) {
        Auction auction = getAuctionByName(auctionName);
        if (auction == null || !auctionList.contains(auction)) {
            throw new RuntimeException("Invalid auction");
        }

        String winner = getAuctionWinner(auction);
        // Do something with winner if needed
        auctionList.remove(auction);
    }

    private Seller getSellerByName(String name) {
        for (Seller seller : sellerList) {
            if (seller.getSellerName().equals(name)) {
                return seller;
            }
        }
        return null;
    }

    private Auction getAuctionByName(String name) {
        for (Auction auction : auctionList) {
            if (auction.getAuctionName().equals(name)) {
                return auction;
            }
        }
        return null;
    }
}