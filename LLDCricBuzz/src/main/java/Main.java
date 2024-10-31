import java.util.*;

public class Main {
    public static void main(String[] args){
        Main ob = new Main();
        Team A = ob.addTeam("India");
        Team B = ob.addTeam("Australia");

        MatchType matchType = new T20MatchType();
        Match match = new Match(A,B,"Eden",null,matchType);
        match.startmatch();

    }

    private Team addTeam(String name){
        Queue<Player> players = new LinkedList<>();

        Player p1 = addPlayer(name+"1", PlayerType.ALLROUNDER);
        Player p2 = addPlayer(name+"2", PlayerType.ALLROUNDER);
        Player p3 = addPlayer(name+"3", PlayerType.ALLROUNDER);
        Player p4 = addPlayer(name+"4", PlayerType.ALLROUNDER);
        Player p5 = addPlayer(name+"5", PlayerType.ALLROUNDER);
        Player p6 = addPlayer(name+"6", PlayerType.ALLROUNDER);
        Player p7 = addPlayer(name+"7", PlayerType.ALLROUNDER);
        Player p8 = addPlayer(name+"8", PlayerType.ALLROUNDER);
        Player p9 = addPlayer(name+"9", PlayerType.ALLROUNDER);
        Player p10 = addPlayer(name+"10", PlayerType.ALLROUNDER);
        Player p11 = addPlayer(name+"11", PlayerType.ALLROUNDER);


        players.add(p1);
        players.add(p2);
        players.add(p3);
        players.add(p4);
        players.add(p5);
        players.add(p6);
        players.add(p7);
        players.add(p8);
        players.add(p9);
        players.add(p10);
        players.add(p11);

        List<Player> bowlers = new ArrayList<>();
        bowlers.add(p8);
        bowlers.add(p9);
        bowlers.add(p10);
        bowlers.add(p11);

        Team team = new Team(name,players,new ArrayList<>(),bowlers);
        return team;

    }

    private Player addPlayer(String name, PlayerType playerType) {

        Person person = new Person();
        person.personName = name;
        Player playerDetails = new Player(person, playerType);
        return playerDetails;
    }

}
