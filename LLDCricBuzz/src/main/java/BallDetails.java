import java.util.ArrayList;
import java.util.List;

public class BallDetails {
    int ballNumber;

    BallType ballType;

    RunType runType;

    Player playedBy;

    Player bowledBy;

    Wicket wicket;

    List<ScoreUpdaterObserver> scoreUpdaterObserverList = new ArrayList<>();

    public BallDetails(int ballNumber){
        this.ballNumber = ballNumber;
        scoreUpdaterObserverList.add(new BowlingScoreUpdater());
        scoreUpdaterObserverList.add(new BattingScoreUpdater());
    }

    public void startBallDelivery(Team battingTeam,Team bowlingTeam,OverDetails overDetails){
        playedBy = battingTeam.getStriker();
        bowledBy = bowlingTeam.getCurrentBowler();

        ballType = BallType.NORMAL;

        if(isWicketTaken()){
            runType = RunType.ZERO;
            wicket = new Wicket(WicketType.BOWLED,bowledBy,overDetails,this);
            battingTeam.setStriker(null);
        }
        else{
            this.runType = getRunType();

            if(runType == RunType.ONE || runType == RunType.THREE){
                Player temp = battingTeam.getStriker();
                battingTeam.playerBattingController.setInStrike(battingTeam.getNonStriker());
                battingTeam.playerBattingController.setNonStrike(temp);
            }
        }

        notifyObserver(this);
    }

    public void notifyObserver(BallDetails ballDetails){
        for(ScoreUpdaterObserver scoreUpdaterObserver : scoreUpdaterObserverList){
            scoreUpdaterObserver.update(ballDetails);
        }
    }

    public RunType getRunType(){
        double val = Math.random();
        if(val < 0.2){
            return RunType.ONE;
        }
        else if(val >= 0.2 && val< 0.3){
            return RunType.TWO;
        }
        else if(val > 0.3 && val < 0.5){
            return RunType.THREE;
        }
        else if(val >=0.5 && val < 0.7){
            return RunType.FOUR;
        }
        else if(val >= 0.7 && val < 0.9){
            return RunType.SIX;
        }
        else return RunType.ZERO;
    }

    public boolean isWicketTaken(){
        double val = Math.random();

        if(val < 0.4){
            return true;
        }
        else{
            return false;
        }
    }
}
