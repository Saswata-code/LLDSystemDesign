import java.util.List;
import java.util.Queue;

public class Team {

    String teamID;

    String teamName;

    Queue<Player> playing11;

    List<Player> benchPlayers;

    PlayerBattingController playerBattingController;

    PlayerBowlingController playerBowlingController;

    boolean isWinner;

    public Team(String teamName,Queue<Player> playing11,List<Player> benchPlayers,List<Player> bowlers){
        this.teamName = teamName;
        this.playing11 = playing11;
        this.benchPlayers = benchPlayers;
        this.playerBattingController = new PlayerBattingController(playing11);
        this.playerBowlingController = new PlayerBowlingController(bowlers);

    }

    public String getTeamName(){
        return teamName;
    }

    public void chooseNextBatsman() throws Exception{
        playerBattingController.getNextPlayer();
    }

    public void chooseNextBowler(int maxOversBowlerAllowed){
        playerBowlingController.getNextBowler(maxOversBowlerAllowed);
    }

    public Player getCurrentBowler(){
        return playerBowlingController.getCurrentBowler();
    }

    public int getTotalRuns(){
        int totalRuns=0;
        for(Player player : playing11){
            totalRuns += player.battingScorecard.runsScored;
        }
        return totalRuns;
    }

    public Player getStriker(){
        return playerBattingController.getInStrike();
    }

    public Player getNonStriker(){
        return playerBattingController.getNonStrike();
    }

    public void setStriker(Player player){
        playerBattingController.setInStrike(player);
    }

    public void setNonStriker(Player player){
        playerBattingController.setNonStrike(player);
    }

    public void printBattingScoreCard(){
        for(Player player : playing11){
            player.printBattingScoreCard();
        }
    }

    public void printBowlingScoreCard(){
        for(Player player : playing11){
            player.printBowlingScoreCard();
        }
    }


}
