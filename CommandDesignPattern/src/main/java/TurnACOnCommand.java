// this is concrete Command class
public class TurnACOnCommand implements ICommand{
    AirConditioner airConditioner;

    public TurnACOnCommand(AirConditioner airConditioner){
        this.airConditioner = airConditioner;
    }
    @Override
    public void execute() {
        airConditioner.setACOn();
    }

    @Override
    public void undo() {
        airConditioner.setACOff();
    }
}
