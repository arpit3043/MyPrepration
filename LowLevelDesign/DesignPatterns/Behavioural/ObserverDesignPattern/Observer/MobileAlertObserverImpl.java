package DesignPatterns.Behavioural.ObserverDesignPattern.Observer;

import DesignPatterns.Behavioural.ObserverDesignPattern.Observable.StockObservable;

public class MobileAlertObserverImpl implements NotificationAlertObserver {
    String userName;
    StockObservable observable;

    public MobileAlertObserverImpl(String userName, StockObservable observable) {
        this.userName = userName;
        this.observable = observable;
    }

    @Override
    public void update() {
        sendMessageOnMobile(userName, "product is in stock, hurry Up !");
    }

    private void sendMessageOnMobile(String userName, String message) {
        System.out.println("message sent to " + userName);
        // send the actual message to end user
    }
}