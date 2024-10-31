public class IdleState extends AtmState{
    @Override
    public void insertCard(ATM atm,Card card){
        System.out.println("Card is inserted");
        atm.setAtmState(new HasCardState());
    }
}
