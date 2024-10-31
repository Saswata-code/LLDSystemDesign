public class Player {

    Person person;

    PlayerType playerType;

    BattingScoreCard battingScorecard;

    BowlingScoreCard bowlingScoreCard;

    public Player(Person person,PlayerType playerType){
        this.person = person;
        this.playerType = playerType;
        this.battingScorecard = new BattingScoreCard();
        this.bowlingScoreCard = new BowlingScoreCard();
    }

    public void printBattingScoreCard(){

        System.out.println("PlayerName: " + person.personName + " -- totalRuns: " + battingScorecard.runsScored
                + " -- totalBallsPlayed: " + battingScorecard.totalBallsPlayed + " -- 4s: " + battingScorecard.numberOf4s
                + " -- 6s: " + battingScorecard.getNumberOf6s + " -- outby: " +   ((battingScorecard.wicketDetails != null) ? battingScorecard.wicketDetails.takenBy.person.personName : "notout"));
    }

    public void printBowlingScoreCard(){
        System.out.println("PlayerName: " + person.personName + " -- totalOversThrown: " + bowlingScoreCard.totalOvers
                + " -- totalRunsGiven: " + bowlingScoreCard.runsConceded+ " -- WicketsTaken: " + bowlingScoreCard.wicketsTaken);
    }

}
