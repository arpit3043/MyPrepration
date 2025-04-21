package Designs.OnlineVotingSystem;

import java.util.List;
import java.util.ArrayList;
public class CandidateDatabase {
    private List<Candidate> candidates;

    public CandidateDatabase() {
        this.candidates = new ArrayList<>();
    }

    public void addCandidate(Candidate candidate) {
        candidates.add(candidate);
    }

    public List<Candidate> getCandidates() {
        return candidates;
    }
}
