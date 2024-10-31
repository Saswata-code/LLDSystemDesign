import java.util.ArrayList;
import java.util.List;

public class InningsDetails {

    Team bowlingTeam;

    Team battingTeam;

    List<OverDetails> overs;

    MatchType matchType;


    public InningsDetails(Team bowlingTeam, Team battingTeam, MatchType matchType) {
        this.bowlingTeam = bowlingTeam;
        this.battingTeam = battingTeam;
        this.matchType = matchType;
        this.overs = new ArrayList<>();
    }

    public void start(int runsToWin) {
        try{
            battingTeam.chooseNextBatsman();
        }
        catch(Exception e){

        }

        int numberOfOvers = matchType.numberOfOvers();
        for(int over=1;over<=numberOfOvers;over++){
            bowlingTeam.chooseNextBowler(matchType.maxOversBowlerAllowed());

            OverDetails overDetails = new OverDetails(over,bowlingTeam.getCurrentBowler());
            overs.add(overDetails);

            try{
                boolean won = overDetails.startOver(battingTeam,bowlingTeam,runsToWin);
                if(won==true) {
                    break;
                }
            }
            catch(Exception e){

            }

            //swap striker and non-striker
            Player player = battingTeam.getStriker();
            battingTeam.setStriker(battingTeam.getNonStriker());
            battingTeam.setNonStriker(player);
        }
    }

    public int getTotalRuns(){
        return battingTeam.getTotalRuns();
    }
}
