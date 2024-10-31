public abstract class AtmState {

    public void insertCard(ATM atm,Card card){
        System.out.println("Oops! You did something wrong");
    }

    public void authenticatePin(Card card,ATM atm,int pin){
        System.out.println("Oops! You did something wrong");
    }

    public void chooseOperation(ATM atm,Card card,TransactionType transactionType){
        System.out.println("Oops! You did something wrong");
    }

    public void withdrawCash(ATM atm,Card card,int withdrawAmount){
        System.out.println("Oops! You did something wrong");
    }

    public void displayBalance(ATM atm,Card card){
        System.out.println("Oops! You did something wrong");
    }

    public void returnCard(){
        System.out.println("Oops! You did something wrong");
    }

    public void exit(ATM atm){
        System.out.println("Oops! You did something wrong");
    }
}
