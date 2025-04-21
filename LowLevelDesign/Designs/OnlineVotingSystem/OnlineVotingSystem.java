package Designs.OnlineVotingSystem;

import java.util.ArrayList;
import java.util.List;

import Designs.OnlineVotingSystem.Factory.VotingFactory;
import Designs.OnlineVotingSystem.Stratergy.AuthenticationStrategy;

public class OnlineVotingSystem {
    private VoterDatabase voterDatabase;
    private CandidateDatabase candidateDatabase;
    private Ballot ballot;
    private EncryptionStrategy encryptionStrategy;
    private AuthenticationStrategy authenticationStrategy;

    public OnlineVotingSystem(VotingFactory factory) {
        this.voterDatabase = new VoterDatabase();
        this.candidateDatabase = new CandidateDatabase();
        this.ballot = new Ballot();
        this.encryptionStrategy = new BasicEncryptor(); // Can be swapped for a different encryption strategy
        this.authenticationStrategy = new PasswordAuthenticationStrategy(); // Can be swapped for a different auth strategy
    }

    public void registerVoter(String name, String password) {
        Voter voter = new Voter(name, password);
        voterDatabase.addVoter(voter);
    }

    public void addCandidate(String name, String party) {
        Candidate candidate = new Candidate(name, party);
        candidateDatabase.addCandidate(candidate);
    }

    public void castVote(Voter voter, Candidate candidate) {
        Command castVote = new CastVoteCommand(voter, candidate, ballot, authenticationStrategy, voterDatabase);
        castVote.execute();
    }

    public List<Candidate> getResults() {
        List<Candidate> results = new ArrayList<>();
        for (Candidate candidate : candidateDatabase.getCandidates()) {
            int votes = ballot.getVotes(candidate);
            String encryptedVotes = encryptionStrategy.encrypt(votes);
            candidate.setEncryptedVotes(encryptedVotes);
            results.add(candidate);
        }
        return results;
    }
}
