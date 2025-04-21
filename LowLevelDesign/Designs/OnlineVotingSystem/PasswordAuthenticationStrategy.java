package Designs.OnlineVotingSystem;

import Designs.OnlineVotingSystem.Stratergy.AuthenticationStrategy;

public class PasswordAuthenticationStrategy implements AuthenticationStrategy {
    @Override
    public boolean authenticate(Voter voter, VoterDatabase voterDatabase) {
        Voter storedVoter = voterDatabase.getVoter(voter.getName());
        if (storedVoter != null && storedVoter.getPassword().equals(voter.getPassword()) && !storedVoter.hasVoted()) {
            storedVoter.vote();
            return true;
        }
        return false;
    }
}
