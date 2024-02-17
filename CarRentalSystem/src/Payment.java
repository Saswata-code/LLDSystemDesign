import java.util.Scanner;

public class Payment {

    Bill bill;

    public Payment(Bill bill) {
        this.bill = bill;
    }

    public void payBill(){
        System.out.println("Your bill amount is:"+bill.amount);
    }
}
