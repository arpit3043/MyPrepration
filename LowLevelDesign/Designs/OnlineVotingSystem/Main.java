package Designs.OnlineVotingSystem;

import java.util.List;

import Designs.OnlineVotingSystem.Factory.VotingFactory;
import Designs.OnlineVotingSystem.Factory.VotingSystemFactory;

public class Main {
    public static void main(String[] args) {
        VotingSystemFactory factory = new VotingSystemFactory();
        OnlineVotingSystem votingSystem = new OnlineVotingSystem(factory);

        // Register voters
        votingSystem.registerVoter("Alice", "password1");
        votingSystem.registerVoter("Bob", "password2");

        // Add candidates
        votingSystem.addCandidate("John Doe", "Party A");
        votingSystem.addCandidate("Jane Smith", "Party B");

        // Create Voter and Candidate instances
        Voter alice = new Voter("Alice", "password1");
        Candidate johnDoe = new Candidate("John Doe", "Party A");

        // Cast vote using the Command Pattern
        votingSystem.castVote(alice, johnDoe);

        // Get and display election results
        List<Candidate> results = votingSystem.getResults();
        for (Candidate candidate : results) {
            System.out.println("Candidate: " + candidate.getName() + ", Encrypted Votes: " + candidate.getEncryptedVotes());
        }
    }
}
