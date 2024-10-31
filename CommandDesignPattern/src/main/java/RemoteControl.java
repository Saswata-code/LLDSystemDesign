import java.util.Stack;
// this is the Invoker
public class RemoteControl {

    ICommand command;

    Stack<ICommand> acCommandHistory = new Stack<>(); //used for undo operation

    public RemoteControl(){}

    public void setCommand(ICommand command){
        this.command = command;
    }

    public void pressButton(){
        command.execute();
        acCommandHistory.push(command);
    }

    public void undo(){

        while(!acCommandHistory.isEmpty()){
            ICommand lastcommand = acCommandHistory.pop();
            lastcommand.undo();
        }
    }
}
