public class Floor {
    int floorID;
    ExternalButton externalButton;

    public Floor(int floorID){
        this.floorID = floorID;
        this.externalButton = new ExternalButton();
    }
}
