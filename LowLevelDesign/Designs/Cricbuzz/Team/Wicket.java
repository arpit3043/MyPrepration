package Designs.Cricbuzz.Team;

import Designs.Cricbuzz.Inning.BallDetails;
import Designs.Cricbuzz.Inning.OverDetails;
import Designs.Cricbuzz.Team.Player.PlayerDetails;

public class Wicket {

    public WicketType wicketType;
    public PlayerDetails takenBy;
    public OverDetails overDetail;
    public BallDetails ballDetail;

    public Wicket(WicketType wicketType, PlayerDetails takenBy, OverDetails overDetail, BallDetails ballDetail){

        this.wicketType = wicketType;
        this.takenBy = takenBy;
        this.overDetail = overDetail;
        this.ballDetail = ballDetail;
    }
}
