public class Main {
    public static void main(String[] args){

        VendingMachine vendingMachine = new VendingMachine();

        try{
          System.out.println("|");
          System.out.println("Filling up inventory");
          System.out.println("|");

          fillUpInventory(vendingMachine);
          displayInventory(vendingMachine);

            System.out.println("|");
            System.out.println("clicking on InsertCoinButton");
            System.out.println("|");

            // clicking on Insert Coin Button, as it is in Idle State
            State vendingState = vendingMachine.getVendingMachineState();
            vendingState.clickOnInsertCoinButton(vendingMachine);

            // Now machine is in Has Money State and can accept coins
            vendingState = vendingMachine.getVendingMachineState();
            vendingState.InsertCoins(vendingMachine,Coin.NICKEL);
            vendingState.InsertCoins(vendingMachine,Coin.QUARTER);
            vendingState.InsertCoins(vendingMachine,Coin.DIME);

            System.out.println("|");
            System.out.println("clicking on ProductSelectionButton");
            System.out.println("|");

            // Coin Insertion is done, now we click on Select Product button
            vendingState.clickOnStartProductSelectionButton(vendingMachine);

            // Vending Machine is in Selection State now
            vendingState = vendingMachine.getVendingMachineState();

            // If the amount was enough, it automatically sets the vending state to Dispense State and dispenses the product
            vendingState.chooseProduct(vendingMachine,104);


        }
        catch(Exception e){
            System.out.println(e.toString());
            displayInventory(vendingMachine);
        }
    }

    public static void fillUpInventory(VendingMachine vendingMachine){

        ItemShelf[] itemShelves = vendingMachine.getInventory().getInventory();

        for(int i=0;i< itemShelves.length;i++){
            Item item = new Item();
            if(i>=0 && i<3){
                item.setItemType(ItemType.COKE);
                item.setPrice(12);
            }
            else if(i>=3 && i<5){
                item.setItemType(ItemType.JUICE);
                item.setPrice(25);
            }
            else if(i>=5 && i<8){
                item.setItemType(ItemType.SODA);
                item.setPrice(15);
            }
            else if(i>=8 && i<10){
                item.setItemType(ItemType.WATER);
                item.setPrice(10);
            }
            itemShelves[i].setItem(item);
            itemShelves[i].setSoldOut(false);
        }
    }

    public static void displayInventory(VendingMachine vendingMachine){

        ItemShelf[] slots = vendingMachine.getInventory().getInventory();
        for (int i = 0; i < slots.length; i++) {

            System.out.println("CodeNumber: " + slots[i].getCode() +
                    " Item: " + slots[i].getItem().getItemType().name() +
                    " Price: " + slots[i].getItem().getPrice() +
                    " isAvailable: " + !slots[i].isSoldOut());
        }

    }
}
