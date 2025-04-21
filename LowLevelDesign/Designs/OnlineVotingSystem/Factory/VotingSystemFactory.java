package Designs.OnlineVotingSystem.Factory;

import Designs.OnlineVotingSystem.Candidate;
import Designs.OnlineVotingSystem.Voter;

public class VotingSystemFactory implements VotingFactory {
    @Override
    public Voter createVoter(String name, String password) {
        return new Voter(name, password);
    }

    @Override
    public Candidate createCandidate(String name, String party) {
        return new Candidate(name, party);
    }
}