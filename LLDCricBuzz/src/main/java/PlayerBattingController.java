import java.util.LinkedList;
import java.util.Queue;

public class PlayerBattingController {

    Queue<Player> yetToBat;

    Player inStrike;

    Player nonStrike;

    public PlayerBattingController(Queue<Player> yetToBat) {
        this.yetToBat = new LinkedList<>();
        this.yetToBat.addAll(yetToBat);
    }

    public Player getInStrike() {
        return inStrike;
    }

    public void setInStrike(Player inStrike) {
        this.inStrike = inStrike;
    }

    public Player getNonStrike() {
        return nonStrike;
    }

    public void setNonStrike(Player nonStrike) {
        this.nonStrike = nonStrike;
    }

    public void getNextPlayer() throws Exception{
        if(yetToBat.isEmpty()){
            throw new Exception();
        }

        if(inStrike==null){
            inStrike = yetToBat.poll();
        }

        if(nonStrike==null){
            nonStrike = yetToBat.poll();
        }
    }
}
