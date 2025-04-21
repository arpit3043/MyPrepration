package Designs.OnlineVotingSystem.Factory;

import Designs.OnlineVotingSystem.Candidate;
import Designs.OnlineVotingSystem.Voter;

interface VotingFactory {
    Voter createVoter(String name, String password);
    Candidate createCandidate(String name, String party);
}
