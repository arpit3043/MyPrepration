package Designs.OnlineVotingSystem.Stratergy;

import Designs.OnlineVotingSystem.Voter;
import Designs.OnlineVotingSystem.VoterDatabase;

interface AuthenticationStrategy {
    boolean authenticate(Voter voter, VoterDatabase voterDatabase);
}
