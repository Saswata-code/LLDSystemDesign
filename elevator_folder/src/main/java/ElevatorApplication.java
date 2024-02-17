import java.util.ArrayList;
import java.util.List;

public class ElevatorApplication {

    public static void main(String[] args){
        Floor floor1 = new Floor(1);
        Floor floor2 = new Floor(2);
        Floor floor3 = new Floor(3);
        Floor floor4 = new Floor(4);
        Floor floor5 = new Floor(5);

        List<Floor> floorList = new ArrayList<>();
        floorList.add(floor1);
        floorList.add(floor2);
        floorList.add(floor3);
        floorList.add(floor4);
        floorList.add(floor5);

        Building building = new Building(floorList);

        ElevatorCreator elevatorCreator = new ElevatorCreator();

        // Internal Button Call to go to 5th floor
        ElevatorCreator.elevatorControllerList.get(0).elevatorCar.pressButton(5);

        // External Button Call for the elevator to reach 3rd floor
        floor3.externalButton.pressButton(3,Direction.DOWN);

        //Internal Button Call to go to 4th floor
        ElevatorCreator.elevatorControllerList.get(0).elevatorCar.pressButton(4);

        // External Button Call to go to 2nd Floor
        floor2.externalButton.pressButton(2,Direction.DOWN);

        ElevatorCreator.elevatorControllerList.get(0).controlElevatorCar();

        floor3.externalButton.pressButton(3,Direction.DOWN);


    }
}
