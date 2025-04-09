package DesignPatterns.Behavioural.ObserverDesignPattern.Observer;

import DesignPatterns.Behavioural.ObserverDesignPattern.Observable.StockObservable;

public class EmailAlertObserverImpl implements NotificationAlertObserver {
    String emailId;
    StockObservable observable;
    
    public EmailAlertObserverImpl(String emailId, StockObservable observable) {
        this.emailId = emailId;
        this.observable = observable;
    }

    @Override
    public void update() {
        sendEmail(emailId, "product is in stock, hurry Up !");        
    }

    private void sendEmail(String emailId, String message) {
        System.out.println("mail sent to " + emailId); 
        // send the actual mail to end user       
    }
}