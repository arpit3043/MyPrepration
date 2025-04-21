package Designs.OnlineVotingSystem.Observer;

public class BallotObserver implements Observer {
    @Override
    public void update(String message) {
        System.out.println("Ballot Update: " + message);
    }
}
