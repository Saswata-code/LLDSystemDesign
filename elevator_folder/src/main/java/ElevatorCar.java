public class ElevatorCar {

    int elevatorId;

    Display display;

    InternalButton internalButton;

    int currentFloor;

    Direction direction;

    Status status;

    Door door;

    public ElevatorCar(){
        internalButton = new InternalButton();
        currentFloor = 0;
        direction = Direction.UP;
    }

    public void pressButton(int destination) {
        internalButton.pressButton(destination, this);
    }

    public void move(int destinationFloor){
        System.out.println("We reached at Floor : " + destinationFloor);
        currentFloor = destinationFloor;
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
