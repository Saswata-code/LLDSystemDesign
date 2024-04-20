import java.util.List;

public class SelectionState implements State{
    public SelectionState(){
        System.out.println("Currently the Vending Machine is in Product Selection State");
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine vendingMachine) throws Exception {
        throw new Exception("You cannot click on Insert Coin in Selection State");
    }

    @Override
    public void InsertCoins(VendingMachine vendingMachine, Coin coin) throws Exception {
        throw new Exception("You cannot Insert Coins in Selection State");
    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine vendingMachine) throws Exception {
        throw new Exception("You cannot click on Product Selection as you are already in Product Selection State");
    }

    @Override
    public void chooseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception {

        // 1. get item of this code Number
        Item item = vendingMachine.getInventory().getItem(codeNumber);
        System.out.println("The item is : " + item.getItemType());

        // 2. Calculate the total amount paid by user.
        int paidByUser=0;
        for(Coin coin : vendingMachine.getCoinList()){
            paidByUser += coin.value;
        }

        // check if sufficient amount paid by User
        if(paidByUser < item.getPrice()){
            System.out.println("Insufficent Amount, the price of product is " + item.getPrice() + " and the amount you paid is " + paidByUser);
            refundFullMoney(vendingMachine);
            throw new Exception("Insufficient Amount");
        }
        else if(paidByUser >= item.getPrice()){
            System.out.println("You can buy the product");
            if(paidByUser > item.getPrice()){
                getChange(paidByUser - item.getPrice());
            }
            vendingMachine.setVendingMachineState(new DispenseState(vendingMachine,codeNumber));
        }
    }

    @Override
    public int getChange(int changeMoney) throws Exception {
        System.out.println("Returned the change in the Coin Dispense Tray " + changeMoney);
        return changeMoney;
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine vendingMachine) throws Exception {
        System.out.println("Return all the coins in the Coin Dispense Tray " + vendingMachine.getCoinList());
        List<Coin> allCoins = vendingMachine.getCoinList();
        vendingMachine.setVendingMachineState(new IdleState(vendingMachine));
        return allCoins;
    }

    @Override
    public Item dispenseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception {
        throw new Exception("Product cannot be dispensed in Selection State");
    }

    @Override
    public void updateInventory(VendingMachine vendingMachine, Item item, int codeNumber) throws Exception {
        throw new Exception("Inventory cannot be updated in Selection State");
    }
}
