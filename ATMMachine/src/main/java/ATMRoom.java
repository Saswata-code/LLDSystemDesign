public class ATMRoom {
    ATM atm;
    User user;

    public static void main(String[] args){
        ATMRoom atmRoom = new ATMRoom();
        atmRoom.initialise();

        atmRoom.atm.displayBalance();
        atmRoom.atm.getAtmState().insertCard(atmRoom.atm,atmRoom.user.card);
        atmRoom.atm.getAtmState().authenticatePin(atmRoom.user.card,atmRoom.atm,112211);
        atmRoom.atm.getAtmState().chooseOperation(atmRoom.atm,atmRoom.user.card,TransactionType.CASH_WITHDRAWAL);
        atmRoom.atm.getAtmState().withdrawCash(atmRoom.atm,atmRoom.user.card,3000);
        atmRoom.atm.displayBalance();
    }

    private void initialise(){
       atm = ATM.getATMObject();
       atm.setAtmBalance(3500,1,1,10);

       // create user
        this.user = createUser();

    }

    private User createUser(){
        User user = new User();
        user.setCard(createCard());
        return user;
    }

    private Card createCard(){
        Card card = new Card();
        card.setBankAccount(createBankAccount());
        return card;

    }

    private UserBankAccount createBankAccount(){
        UserBankAccount userBankAccount = new UserBankAccount();
        userBankAccount.setBalance(5000);
        return userBankAccount;
    }
}
