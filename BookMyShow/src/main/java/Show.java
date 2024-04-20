import java.util.ArrayList;
import java.util.List;

public class Show {

    int showID;

    Movie movie;

    Screen screen;

    List<Integer> bookedSeatIDs = new ArrayList<>();

    int startTime;

    public int getShowID() {
        return showID;
    }

    public void setShowID(int showID) {
        this.showID = showID;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public List<Integer> getBookedSeatIDs() {
        return bookedSeatIDs;
    }

    public void setBookedSeatIDs(List<Integer> bookedSeatIDs) {
        this.bookedSeatIDs = bookedSeatIDs;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }
}
