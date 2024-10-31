public class Wicket {
    WicketType wicketType;

    Player takenBy;

    OverDetails overDetails;

    BallDetails ballDetails;

    public Wicket(WicketType wicketType, Player takenBy, OverDetails overDetails, BallDetails ballDetails) {
        this.wicketType = wicketType;
        this.takenBy = takenBy;
        this.overDetails = overDetails;
        this.ballDetails = ballDetails;
    }
}
