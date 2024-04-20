import java.util.List;

public class DispenseState implements State{

    public DispenseState(VendingMachine vendingMachine,int codeNumber) throws Exception{
        System.out.println("Currently the machine is in Dispense State");
        dispenseProduct(vendingMachine,codeNumber);
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine vendingMachine) throws Exception {
        throw new Exception("You cannot click on Insert Coin in Dispense State");
    }

    @Override
    public void InsertCoins(VendingMachine vendingMachine, Coin coin) throws Exception {
        throw new Exception("You cannot Insert Coins in Dispense State");
    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine vendingMachine) throws Exception {
        throw new Exception("You cannot click on Select Product Button in Dispense State");
    }

    @Override
    public void chooseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception {
        throw new Exception("You cannot choose Products in Dispense State");
    }

    @Override
    public int getChange(int changeMoney) throws Exception {
        throw new Exception("You cannot get Change in Dispense State");
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine vendingMachine) throws Exception {
        throw new Exception("You cannot get Refund in Dispense State");
    }

    @Override
    public Item dispenseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception {
        Item item = vendingMachine.getInventory().getItem(codeNumber);
        System.out.println("Dispensing the " + item.itemType + " in the product tray");
        vendingMachine.getInventory().updateSoldOutItem(codeNumber);
        vendingMachine.setVendingMachineState(new IdleState(vendingMachine));
        return item;
    }

    @Override
    public void updateInventory(VendingMachine vendingMachine, Item item, int codeNumber) throws Exception {
        throw new Exception("Inventory cannot be updated in Dispense State");
    }
}
