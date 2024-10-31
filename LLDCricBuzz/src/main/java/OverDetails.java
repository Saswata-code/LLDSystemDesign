import java.util.List;

public class OverDetails {

    int overNo;

    List<BallDetails> balls;

    int extraBallCount;

    Player bowledBy;

    public OverDetails(int overNo,Player bowledBy){
        this.overNo = overNo;
        this.bowledBy = bowledBy;
    }

    public boolean startOver(Team battingTeam,Team bowlingTeam,int runsToWin) throws Exception{

        int ballCount=1;
        while(ballCount<=6){
            BallDetails ball = new BallDetails(ballCount);
            ball.startBallDelivery(battingTeam,bowlingTeam,this);

            if(ball.ballType == BallType.NORMAL){
                balls.add(ball);
                ballCount++;

                if(ball.wicket!=null){
                    battingTeam.chooseNextBatsman();
                }

                if(runsToWin!=-1 && battingTeam.getTotalRuns()> runsToWin){
                    battingTeam.isWinner = true;
                    return true;
                }
            }
            else{
                extraBallCount++;
            }
        }

        return false;

    }



}
