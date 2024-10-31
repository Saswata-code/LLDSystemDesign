public class CashWithdrawState extends AtmState{

    public CashWithdrawState(){
        System.out.println("Enter the amount you want to withdraw");
    }

    public void withdrawCash(ATM atm,Card card,int withdrawAmount){

        if(atm.getAtmBalance() < withdrawAmount){
            System.out.println("ATM has insufficient balance");
            exit(atm);
        }
        else if(card.getBankBalance() < withdrawAmount){
            System.out.println("Bank Balance is insufficient");
            exit(atm);
        }
        else{
            card.deductBankBalance(withdrawAmount);
            atm.deductAtmBalance(withdrawAmount);
            // Write logic for Cash Withdraw Processor i.e how many 2k Notes reqd, 500 Notes reqd,100 Notes reqd etc.
            CashWithdrawProcessor cashWithdrawProcessor = new TwoThousandCashWithdrawProcessor(new FiveHundredCashWithdrawProcessor(new OneHundredCashWithdrawProcessor(null)));
            cashWithdrawProcessor.withdraw(atm,withdrawAmount);
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
}
