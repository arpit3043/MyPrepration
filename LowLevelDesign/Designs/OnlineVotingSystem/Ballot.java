package Designs.OnlineVotingSystem;

import java.util.Map;

import Designs.OnlineVotingSystem.Observer.Observer;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Ballot {
    private Map<Candidate, Integer> votes;
    private List<Observer> observers;

    public Ballot() {
        this.votes = new HashMap<>();
        this.observers = new ArrayList<>();
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    private void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    public void addVote(Candidate candidate) {
        votes.put(candidate, votes.getOrDefault(candidate, 0) + 1);
        notifyObservers("Vote added for candidate: " + candidate.getName());
    }

    public int getVotes(Candidate candidate) {
        return votes.getOrDefault(candidate, 0);
    }
}
