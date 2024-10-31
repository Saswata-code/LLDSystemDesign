import java.util.Date;

public class Match {

    Team A;

    Team B;

    String venue;

    Date matchDate;

    InningsDetails[] innings;

    MatchType matchType;

    Team tossWinner;

    public Match(Team a, Team b, String venue, Date matchDate, MatchType matchType) {
        this.A = a;
        this.B = b;
        this.venue = venue;
        this.matchDate = matchDate;
        this.matchType = matchType;
        this.innings = new InningsDetails[2];
    }

    public void startmatch(){
        tossWinner = toss(A,B);

        for(int inning=1;inning<=2;inning++){
            InningsDetails inningsDetails;
            Team battingTeam;
            Team bowlingTeam;

            if(inning==1){
                battingTeam = tossWinner;
                bowlingTeam = tossWinner.getTeamName().equals(A.getTeamName()) ? B : A;
                inningsDetails = new InningsDetails(battingTeam,bowlingTeam,matchType);
                inningsDetails.start(-1);
            }
            else{
                bowlingTeam = tossWinner;
                battingTeam = tossWinner.getTeamName().equals(A.getTeamName()) ? B : A;
                inningsDetails = new InningsDetails(battingTeam,bowlingTeam,matchType);
                inningsDetails.start(innings[0].getTotalRuns());
                if(bowlingTeam.getTotalRuns() > battingTeam.getTotalRuns()){
                    bowlingTeam.isWinner = true;
                }
            }

            innings[inning-1] = inningsDetails;

            System.out.println();
            System.out.println("INNING " + inning + " -- total Run: " + battingTeam.getTotalRuns());
            System.out.println("---Batting ScoreCard : " + battingTeam.teamName + "---");

            battingTeam.printBattingScoreCard();

            System.out.println();
            System.out.println("---Bowling ScoreCard : " + bowlingTeam.teamName + "---");
            bowlingTeam.printBowlingScoreCard();


        }

        System.out.println();
        if(A.isWinner){
            System.out.println("Winner is: " + A.getTeamName());
        }
        else{
            System.out.println("Winner is : " + B.getTeamName());
        }


    }

    private Team toss(Team A, Team B){
        if(Math.random() < 0.5){
            return A;
        }
        else{
            return B;
        }
    }
}
