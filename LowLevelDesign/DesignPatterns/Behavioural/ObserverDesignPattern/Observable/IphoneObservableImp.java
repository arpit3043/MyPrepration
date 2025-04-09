package DesignPatterns.Behavioural.ObserverDesignPattern.Observable;

import java.util.ArrayList;
import java.util.List;
import DesignPatterns.Behavioural.ObserverDesignPattern.Observer.NotificationAlertObserver;

public class IphoneObservableImp implements StockObservable {
    public List<NotificationAlertObserver> observersList =  new ArrayList<>();
    private int stockCount = 0;

    @Override
    public void add(NotificationAlertObserver observer) {
        observersList.add(observer);
    }

    @Override
    public void remove(NotificationAlertObserver observer) {
        observersList.remove(observer);
    }

    @Override
    public void notifySubscribers() {
        for (NotificationAlertObserver observer : observersList) {
            observer.update();
        }
    }

    @Override
    public void setStockCount(int newStockAdded) {
        if(stockCount == 0) {
            notifySubscribers();
        }
        stockCount += newStockAdded;
    }

    public int getStockCount() {
        return stockCount;
    }
}