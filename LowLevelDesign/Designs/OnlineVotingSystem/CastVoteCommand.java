package Designs.OnlineVotingSystem;

import Designs.OnlineVotingSystem.Stratergy.AuthenticationStrategy;

public class CastVoteCommand implements Command {
    private Voter voter;
    private Candidate candidate;
    private Ballot ballot;
    private AuthenticationStrategy authenticationStrategy;
    private VoterDatabase voterDatabase;

    public CastVoteCommand(Voter voter, Candidate candidate, Ballot ballot, AuthenticationStrategy authStrategy, VoterDatabase voterDatabase) {
        this.voter = voter;
        this.candidate = candidate;
        this.ballot = ballot;
        this.authenticationStrategy = authStrategy;
        this.voterDatabase = voterDatabase;
    }

    @Override
    public void execute() {
        if (authenticationStrategy.authenticate(voter, voterDatabase)) {
            ballot.addVote(candidate);
        } else {
            System.out.println("Authentication failed or voter has already voted.");
        }
    }
}
