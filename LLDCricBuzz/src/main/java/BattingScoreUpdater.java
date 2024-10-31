public class BattingScoreUpdater implements ScoreUpdaterObserver{
    @Override
    public void update(BallDetails ballDetails) {
        int run=0;

        if(ballDetails.runType == RunType.ONE){
            run = 1;
        }
        else if(ballDetails.runType == RunType.TWO){
            run = 2;
        }
        else if(ballDetails.runType == RunType.THREE){
            run = 3;
        }
        else if(ballDetails.runType == RunType.FOUR){
            run = 4;
            ballDetails.playedBy.battingScorecard.numberOf4s++;
        }
        else if(ballDetails.runType == RunType.SIX){
            run = 6;
            ballDetails.playedBy.battingScorecard.getNumberOf6s++;
        }

        ballDetails.playedBy.battingScorecard.runsScored += run;
        ballDetails.playedBy.battingScorecard.totalBallsPlayed++;

        if(ballDetails.wicket!=null){
           ballDetails.playedBy.battingScorecard.wicketDetails = ballDetails.wicket;
        }
    }
}
