public class TwoThousandCashWithdrawProcessor extends CashWithdrawProcessor{


    public TwoThousandCashWithdrawProcessor(CashWithdrawProcessor cashWithdrawProcessor) {
        super(cashWithdrawProcessor);
    }

    public void withdraw(ATM atm,int amount){
        int noOfTwoThousandNotesNeeded = amount / 2000;
        int balance = amount % 2000;

        if(noOfTwoThousandNotesNeeded <= atm.getNoOfTwoThousandNotes()){
            atm.deductTwoThousandNotes(noOfTwoThousandNotesNeeded);
        }
        else if(noOfTwoThousandNotesNeeded > atm.getNoOfTwoThousandNotes()){
            balance = balance + (noOfTwoThousandNotesNeeded - atm.getNoOfTwoThousandNotes()) * 2000;
            atm.deductTwoThousandNotes(atm.getNoOfTwoThousandNotes());
        }

        if(balance != 0){
            super.withdraw(atm,balance);
        }
    }
}
