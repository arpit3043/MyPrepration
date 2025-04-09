package DesignPatterns.Behavioural.ObserverDesignPattern;

import DesignPatterns.Behavioural.ObserverDesignPattern.Observable.IphoneObservableImp;
import DesignPatterns.Behavioural.ObserverDesignPattern.Observable.StockObservable;
import DesignPatterns.Behavioural.ObserverDesignPattern.Observer.EmailAlertObserverImpl;
import DesignPatterns.Behavioural.ObserverDesignPattern.Observer.MobileAlertObserverImpl;
import DesignPatterns.Behavioural.ObserverDesignPattern.Observer.NotificationAlertObserver;

public class Store {
    public static void main(String[] args) {
        StockObservable iphoneStockObservable = new IphoneObservableImp();
        
        NotificationAlertObserver observer1 = new EmailAlertObserverImpl("xyz@gmail.com", iphoneStockObservable);
        NotificationAlertObserver observer2 = new EmailAlertObserverImpl("xyz2@gmail.com", iphoneStockObservable);
        NotificationAlertObserver observer3 = new MobileAlertObserverImpl("xyz_username", iphoneStockObservable);

        iphoneStockObservable.add(observer1); // register observer1 to the observable object
        iphoneStockObservable.add(observer2); // register observer2 to the observable object
        iphoneStockObservable.add(observer3); // register observer3 to the observable object

        iphoneStockObservable.setStockCount(10); // set stock count to 10, this will notify all observers
        System.out.println("Current stock count is: " + iphoneStockObservable.getStockCount());
    }
}