public class FiveHundredCashWithdrawProcessor extends CashWithdrawProcessor{

    public FiveHundredCashWithdrawProcessor(CashWithdrawProcessor cashWithdrawProcessor){
        super(cashWithdrawProcessor);
    }

    public void withdraw(ATM atm,int amount){
        int noOfFiveHundredNotesNeeded = amount / 500;
        int balance = amount % 500;

        if(noOfFiveHundredNotesNeeded <= atm.getNoOfFiveHundredNotes()){
            atm.deductFiveHundredNotes(noOfFiveHundredNotesNeeded);
        }
        else if(noOfFiveHundredNotesNeeded > atm.getNoOfFiveHundredNotes()){
            balance = balance + (noOfFiveHundredNotesNeeded - atm.getNoOfFiveHundredNotes()) * 500;
            atm.deductFiveHundredNotes(atm.getNoOfFiveHundredNotes());
        }

        if(balance != 0){
            super.withdraw(atm,balance);
        }
    }
}
