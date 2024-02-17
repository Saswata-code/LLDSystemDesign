import java.util.List;

public class ExternalButtonDispatcher {
    List<ElevatorController> elevatorControllerList = ElevatorCreator.elevatorControllerList;

    public void submitRequest(int destination,Direction direction){
        ElevatorController elevatorController = elevatorControllerList.get(0);

        elevatorController.acceptNewRequestForExternalButton(destination,direction);
    }
}
