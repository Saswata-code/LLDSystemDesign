import java.util.*;

public class ElevatorController {
    ElevatorCar elevatorCar;

    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;
    Queue<Integer> pendingJobs;

    public ElevatorController(ElevatorCar elevatorCar){
        this.min = new PriorityQueue<>();
        this.max =  new PriorityQueue<>(Collections.reverseOrder());
        this.pendingJobs = new LinkedList<>();
        this.elevatorCar = elevatorCar;
    }

    public void acceptNewRequestForInternalButton(int destination){

        if(destination == elevatorCar.currentFloor) return;

        if(elevatorCar.direction == Direction.UP && destination > elevatorCar.currentFloor){
            min.add(destination);
        }
        else if(elevatorCar.direction == Direction.DOWN && destination > elevatorCar.currentFloor){
            pendingJobs.add(destination);
        }
        else if(elevatorCar.direction == Direction.UP && destination < elevatorCar.currentFloor){
            pendingJobs.add(destination);
        }
        else if(elevatorCar.direction == Direction.DOWN && destination < elevatorCar.currentFloor) {
            max.add(destination);
        }
    }


    public void acceptNewRequestForExternalButton(int destination,Direction direction){

            if (elevatorCar.direction == Direction.UP && direction == Direction.UP){
                if( destination >= elevatorCar.currentFloor) {
                    min.add(destination);
                } else {
                    pendingJobs.add(destination);
                }
            }
            else if(elevatorCar.direction == Direction.DOWN && direction == Direction.DOWN){
                if(destination <= elevatorCar.currentFloor ){
                    max.add(destination);
                }
                else{
                    pendingJobs.add(destination);
                }
            }
            else if(elevatorCar.direction == Direction.UP && direction == Direction.DOWN){
                max.add(destination);
            }
            else{
                min.add(destination);
            }
    }

    public void controlElevatorCar() {

        while (max.size() > 0 || min.size() > 0 || pendingJobs.size() > 0) {
            if (elevatorCar.direction == Direction.UP && !min.isEmpty()) {
                int destinationFloor = min.poll();
                elevatorCar.move(destinationFloor);

                if (min.isEmpty()) {
                    elevatorCar.direction = Direction.DOWN;
                    // storing the unreachable floors while moving up in pending jobs
                    pendingJobs.stream().map((floor) -> min.add(floor));
                }
            } else if (elevatorCar.direction == Direction.DOWN && !max.isEmpty()) {
                int destinationFloor = max.poll();
                elevatorCar.move(destinationFloor);

                if (max.isEmpty()) {
                    elevatorCar.direction = Direction.UP;
                    // storing the unreachable floors while moving down in pending jobs
                    pendingJobs.stream().map((floor) -> max.add(floor));

                }
            }
        }
    }
}
