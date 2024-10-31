import java.util.Date;

public class Card {
    private int cardNumber;
    private int cvv;
    static int PIN_NUMBER = 112211;
    private UserBankAccount bankAccount;

    public UserBankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(UserBankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public boolean isPINCorrect(int pin){
        if(PIN_NUMBER == pin){
            return true;
        }
        return false;
    }

    public int getBankBalance(){
        return bankAccount.getBalance();
    }

    public void deductBankBalance(int amount){
        bankAccount.withdrawalBalance(amount);
    }
}
