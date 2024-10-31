public class HasCardState extends AtmState{

    public HasCardState(){
        System.out.println("Enter your card's PIN Number: ");
    }

    @Override
    public void authenticatePin(Card card,ATM atm,int pin){

        boolean isPINEnteredCorrectly = card.isPINCorrect(pin);

        if(isPINEnteredCorrectly){
            atm.setAtmState(new SelectionState());
        }
        else{
            exit(atm);
            atm.setAtmState(new IdleState());
        }
    }

    @Override
    public void exit(ATM atm){
        returnCard();
        atm.setAtmState(new IdleState());
        System.out.println("Exit Happens");
    }

    @Override
    public void returnCard(){
        System.out.println("Please collect your card");
    }
}
