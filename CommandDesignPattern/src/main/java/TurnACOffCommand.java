// this is the concrete Command class
public class TurnACOffCommand implements ICommand{
    AirConditioner airConditioner;

    public TurnACOffCommand(AirConditioner airConditioner) {
        this.airConditioner = airConditioner;
    }

    @Override
    public void execute() {
        airConditioner.setACOff();
    }

    @Override
    public void undo() {
        airConditioner.setACOn();
    }
}
