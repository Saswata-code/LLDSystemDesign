import java.util.ArrayList;
import java.util.List;

public class Screen {

    int screenID;

    List<Seat> seats = new ArrayList<>();

    public int getScreenID() {
        return screenID;
    }

    public void setScreenID(int screenID) {
        this.screenID = screenID;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }
}
