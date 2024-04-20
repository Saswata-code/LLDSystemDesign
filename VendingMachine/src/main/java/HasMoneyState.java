import java.util.List;

public class HasMoneyState implements State{
    public HasMoneyState(){
        System.out.println("Currently the vending machine is in Has Money State");
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine vendingMachine) throws Exception {
        throw new Exception("You cannot click on Insert Coin Button in Has Money State");
    }

    @Override
    public void InsertCoins(VendingMachine vendingMachine, Coin coin) throws Exception {
        System.out.println("Accepted the coin");
        vendingMachine.getCoinList().add(coin);
    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine vendingMachine) throws Exception {
        vendingMachine.setVendingMachineState(new SelectionState());
    }

    @Override
    public void chooseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception {
        throw new Exception("You cannot choose product in Has Money State");
    }

    @Override
    public int getChange(int changeMoney) throws Exception {
        throw new Exception("You cannot get change in Has Money State");
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine vendingMachine) throws Exception {
        System.out.println("Refund the full money in Case Dispense Tray");
        List<Coin> allCoins = vendingMachine.getCoinList();
        vendingMachine.setVendingMachineState(new IdleState(vendingMachine));
        return allCoins;
    }

    @Override
    public Item dispenseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception {
        throw new Exception("You cannot dispense product in Has Money State");
    }

    @Override
    public void updateInventory(VendingMachine vendingMachine, Item item, int codeNumber) throws Exception {
        throw new Exception("You cannot update inventory in Has Money State");
    }
}
