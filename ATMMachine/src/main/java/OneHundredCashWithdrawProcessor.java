public class OneHundredCashWithdrawProcessor extends CashWithdrawProcessor{

    public OneHundredCashWithdrawProcessor(CashWithdrawProcessor cashWithdrawProcessor){
        super(cashWithdrawProcessor);
    }

    public void withdraw(ATM atm,int amount){
        int noOfOneHundredNotesNeeded = amount / 100;
        int balance = amount % 100;

        if(noOfOneHundredNotesNeeded <= atm.getNoOfOneHundredNotes()){
            atm.deductOneHundredNotes(noOfOneHundredNotesNeeded);
        }
        else if(noOfOneHundredNotesNeeded > atm.getNoOfOneHundredNotes()){
            balance = balance + (noOfOneHundredNotesNeeded - atm.getNoOfOneHundredNotes()) * 100;
            atm.deductOneHundredNotes(atm.getNoOfOneHundredNotes());
        }

        if(balance != 0){
            System.out.println("Something went wrong");
        }
    }
}
