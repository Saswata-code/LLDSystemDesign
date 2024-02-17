import java.util.ArrayList;
import java.util.List;

public class ElevatorCreator {

    static List<ElevatorController> elevatorControllerList = new ArrayList<>();

    static{
        ElevatorCar elevatorCar = new ElevatorCar();
        ElevatorController elevatorController = new ElevatorController(elevatorCar);

        elevatorControllerList.add(elevatorController);
    }
}
