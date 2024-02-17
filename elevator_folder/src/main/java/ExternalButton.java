public class ExternalButton {

    ExternalButtonDispatcher externalButtonDispatcher;

    public ExternalButton() {
        this.externalButtonDispatcher = new ExternalButtonDispatcher();
    }

    public void pressButton(int destination, Direction direction){
        externalButtonDispatcher.submitRequest(destination,direction);
    }
}
