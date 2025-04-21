package Designs.OnlineVotingSystem;

public class Voter {
    private String name;
    private String password;
    private boolean hasVoted = false;

    public Voter(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public boolean hasVoted() {
        return hasVoted;
    }

    public void vote() {
        this.hasVoted = true;
    }
}
