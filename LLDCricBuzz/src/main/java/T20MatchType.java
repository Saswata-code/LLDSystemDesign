public class T20MatchType implements MatchType{
    @Override
    public int numberOfOvers() {
        return 20;
    }

    @Override
    public int maxOversBowlerAllowed() {
        return 5;
    }
}
