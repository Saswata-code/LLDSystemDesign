import java.util.List;

public class InternalButtonDispatcher {
    List<ElevatorController> elevatorControllerList = ElevatorCreator.elevatorControllerList;

    public void submitRequest(int destination,ElevatorCar elevatorCar){
        // find out the respective Elevator from where the button is pressed;

        ElevatorController elevatorController = elevatorControllerList.stream().findAny().get();

        elevatorController.acceptNewRequestForInternalButton(destination);
    }
}
