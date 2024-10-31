import java.util.*;

public class PlayerBowlingController {

    Deque<Player> bowlers;

    Map<Player,Integer> playerVsOversBowled = new HashMap<>();

    Player currentBowler;

    public PlayerBowlingController(List<Player> bowlers) {
        setBowlerList(bowlers);
    }

    public void setBowlerList(List<Player> bowlers){
        this.bowlers = new LinkedList<>();
        playerVsOversBowled = new HashMap<>();
        for(Player bowler : bowlers){
            this.bowlers.addLast(bowler);
            playerVsOversBowled.put(bowler,0);
        }
    }

    public void getNextBowler(int maxOversBowlersAllowed){
        Player bowler = bowlers.poll();
        if(playerVsOversBowled.get(bowler)+1==maxOversBowlersAllowed){
            currentBowler = bowler;
        }
        else{
            currentBowler = bowler;
            bowlers.addLast(currentBowler);
            playerVsOversBowled.put(currentBowler,playerVsOversBowled.get(currentBowler) + 1);
        }
    }

    public Player getCurrentBowler(){
        return this.currentBowler;
    }
}
