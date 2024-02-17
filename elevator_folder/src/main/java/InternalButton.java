public class InternalButton {

    InternalButtonDispatcher internalButtonDispatcher;

    public InternalButton(){
        this.internalButtonDispatcher = new InternalButtonDispatcher();
    }

    public void pressButton(int destination,ElevatorCar elevatorCar){

        internalButtonDispatcher.submitRequest(destination,elevatorCar);
    }
}
