// this is the Command Layer
public interface ICommand {

    public void execute();
    public void undo();
}
