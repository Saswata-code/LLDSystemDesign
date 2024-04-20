import java.util.ArrayList;
import java.util.List;

public class IdleState implements State{
    public IdleState(){
        System.out.println("Currently machine is in Idle State");
    }

    public IdleState(VendingMachine vendingMachine){
        System.out.println("Currently machine is in Idle State");
        vendingMachine.setCoinList(new ArrayList<>());
    }
    @Override
    public void clickOnInsertCoinButton(VendingMachine vendingMachine) throws Exception {
        vendingMachine.setVendingMachineState(new HasMoneyState());
    }

    @Override
    public void InsertCoins(VendingMachine vendingMachine, Coin coin) throws Exception {
        throw new Exception("You cannot insert coin in Idle State");
    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine vendingMachine) throws Exception {
        throw new Exception("You cannot press Product Selection Button in Idle State");
    }

    @Override
    public void chooseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception {
        throw new Exception("You cannot choose Product in Idle State");
    }

    @Override
    public int getChange(int changeMoney) throws Exception {
        throw new Exception("You cannot get Change in Idle State");
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine vendingMachine) throws Exception {
        throw new Exception("You cannot refund Full Money in Idle State");
    }

    @Override
    public Item dispenseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception {
        throw new Exception("You cannot dispense Product in Idle State");
    }

    @Override
    public void updateInventory(VendingMachine vendingMachine, Item item, int codeNumber) throws Exception {
        vendingMachine.getInventory().addNewItem(item,codeNumber);
    }
}
