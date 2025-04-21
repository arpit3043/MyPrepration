package Designs.OnlineVotingSystem;

public class Candidate {
    private String name;
    private String party;
    private String encryptedVotes;

    public Candidate(String name, String party) {
        this.name = name;
        this.party = party;
    }

    public String getName() {
        return name;
    }

    public String getParty() {
        return party;
    }

    public String getEncryptedVotes() {
        return encryptedVotes;
    }

    public void setEncryptedVotes(String encryptedVotes) {
        this.encryptedVotes = encryptedVotes;
    }
}
