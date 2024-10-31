public class SelectionState extends AtmState{

    public SelectionState(){
        showOperations();
    }

    @Override
    public void chooseOperation(ATM atm,Card card,TransactionType transactionType){

        if(transactionType == TransactionType.CASH_WITHDRAWAL){
            atm.setAtmState(new CashWithdrawState());
        }
        else if(transactionType == TransactionType.CHECK_BALANCE){
            atm.setAtmState(new CheckBalanceState());
        }
        else{
            System.out.println("Invalid Option");
            exit(atm);
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

    public void showOperations(){
        System.out.println("Please select a operation: ");
        TransactionType.showAllTransactionTypes();
    }
}
