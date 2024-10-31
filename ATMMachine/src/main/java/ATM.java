public class ATM {

    private static ATM atm = new ATM();
    AtmState atmState;

    private int atmBalance;
    int noOfTwoThousandNotes;
    int noOfFiveHundredNotes;
    int noOfOneHundredNotes;

    private ATM(){

    }


    public static ATM getATMObject(){
        atm.setAtmState(new IdleState());
        return atm;
    }

    public AtmState getAtmState() {
        return atmState;
    }

    public void setAtmState(AtmState atmState) {
        this.atmState = atmState;
    }

    public int getAtmBalance(){
        return atmBalance;
    }

    public void setAtmBalance(int atmBalance,int noOfTwoThousandNotes,int noOfFiveHundredNotes,int noOfOneHundredNotes){
        this.atmBalance = atmBalance;
        this.noOfTwoThousandNotes = noOfTwoThousandNotes;
        this.noOfFiveHundredNotes = noOfFiveHundredNotes;
        this.noOfOneHundredNotes = noOfOneHundredNotes;
    }

    public int getNoOfTwoThousandNotes() {
        return noOfTwoThousandNotes;
    }

    public int getNoOfFiveHundredNotes() {
        return noOfFiveHundredNotes;
    }

    public int getNoOfOneHundredNotes() {
        return noOfOneHundredNotes;
    }

    public void deductAtmBalance(int amount){
        atmBalance = atmBalance - amount;
    }

    public void deductTwoThousandNotes(int number){
        noOfTwoThousandNotes = noOfTwoThousandNotes - number;
    }

    public void deductFiveHundredNotes(int number){
        noOfFiveHundredNotes = noOfFiveHundredNotes - number;
    }

    public void deductOneHundredNotes(int number){
        noOfOneHundredNotes = noOfOneHundredNotes - number;
    }

    public void displayBalance(){
        System.out.println("Balance: "+atmBalance);
        System.out.println("2kNotes: "+noOfTwoThousandNotes);
        System.out.println("500Notes: "+noOfFiveHundredNotes);
        System.out.println("100Notes: "+noOfOneHundredNotes);
    }


}
