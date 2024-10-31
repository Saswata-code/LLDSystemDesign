public class CashWithdrawProcessor {

    CashWithdrawProcessor cashWithdrawProcessorNext;

    public CashWithdrawProcessor(CashWithdrawProcessor cashWithdrawProcessor){
        this.cashWithdrawProcessorNext = cashWithdrawProcessor;
    }

    public void withdraw(ATM atm,int balance){
        if(cashWithdrawProcessorNext != null){
            cashWithdrawProcessorNext.withdraw(atm,balance);
        }
    }
}
