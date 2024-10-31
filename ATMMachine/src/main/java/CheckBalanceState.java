public class CheckBalanceState extends AtmState{

    public CheckBalanceState(){

    }

    @Override
    public void displayBalance(ATM atm,Card card){

        System.out.println("Your bank balance is: " + card.getBankBalance());
        exit(atm);
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
