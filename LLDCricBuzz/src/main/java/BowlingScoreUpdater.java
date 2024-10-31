public class BowlingScoreUpdater implements ScoreUpdaterObserver{
    @Override
    public void update(BallDetails ballDetails) {

        if(ballDetails.ballNumber==6 && ballDetails.ballType == BallType.NORMAL){
            ballDetails.bowledBy.bowlingScoreCard.totalOvers++;
        }

        if(ballDetails.runType == RunType.ONE){
            ballDetails.bowledBy.bowlingScoreCard.runsConceded += 1;
        }
        else if(ballDetails.runType == RunType.TWO){
            ballDetails.bowledBy.bowlingScoreCard.runsConceded += 2;
        }
        else if(ballDetails.runType == RunType.THREE){
            ballDetails.bowledBy.bowlingScoreCard.runsConceded += 3;
        }
        else if(ballDetails.runType == RunType.FOUR){
            ballDetails.bowledBy.bowlingScoreCard.runsConceded += 4;
        }
        else if(ballDetails.runType == RunType.SIX){
            ballDetails.bowledBy.bowlingScoreCard.runsConceded += 6;
        }

        if(ballDetails.wicket!=null){
            ballDetails.bowledBy.bowlingScoreCard.wicketsTaken++;
        }

        if(ballDetails.ballType == BallType.NOBALL){
            ballDetails.bowledBy.bowlingScoreCard.noBalls++;
        }

        if (ballDetails.ballType == BallType.WIDEBALL) {
            ballDetails.bowledBy.bowlingScoreCard.wideBalls++;
        }
    }
}
