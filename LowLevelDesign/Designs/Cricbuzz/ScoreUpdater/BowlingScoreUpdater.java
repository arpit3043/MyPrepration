package Designs.Cricbuzz.ScoreUpdater;

import Designs.Cricbuzz.Inning.BallDetails;
import Designs.Cricbuzz.Inning.BallType;
import Designs.Cricbuzz.Inning.RunType;

public class BowlingScoreUpdater implements ScoreUpdaterObserver {

    @Override
    public void update(BallDetails ballDetails) {

        if (ballDetails.ballNumber == 6 && ballDetails.ballType == BallType.NORMAL) {
            ballDetails.bowledBy.bowlingScoreCard.totalOversCount++;
        }

        if (RunType.ONE == ballDetails.runType) {
            ballDetails.bowledBy.bowlingScoreCard.runsGiven += 1;
        } else if (RunType.TWO == ballDetails.runType) {
            ballDetails.bowledBy.bowlingScoreCard.runsGiven += 2;
        } else if (RunType.FOUR == ballDetails.runType) {
            ballDetails.bowledBy.bowlingScoreCard.runsGiven += 4;
        } else if (RunType.SIX == ballDetails.runType) {
            ballDetails.bowledBy.bowlingScoreCard.runsGiven += 6;
        }

        if (ballDetails.wicket != null) {
            ballDetails.bowledBy.bowlingScoreCard.wicketsTaken++;
        }

        if (ballDetails.ballType == BallType.NOBALL) {
            ballDetails.bowledBy.bowlingScoreCard.noBallCount++;
        }

        if (ballDetails.ballType == BallType.WIDEBALL) {
            ballDetails.bowledBy.bowlingScoreCard.wideBallCount++;
        }
    }
}
