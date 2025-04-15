package Designs.Cricbuzz.ScoreUpdater;


import Designs.Cricbuzz.Inning.BallDetails;

public interface ScoreUpdaterObserver {
    public void update(BallDetails ballDetails);
}
