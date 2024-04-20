import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BookMyShow {

    MovieController movieController;
    TheatreController theatreController;

    public BookMyShow(){
       movieController = new MovieController();
       theatreController = new TheatreController();
    }

    public static void main(String[] args){

        BookMyShow bookMyShow = new BookMyShow();
        bookMyShow.initialise();

        // user 1 booking show
        bookMyShow.createBooking(City.BANGALORE,"Baahubali");

        // user 2 booking show
        bookMyShow.createBooking(City.BANGALORE,"Baahubali");
    }

    public void initialise(){
        createMovies();
        createTheatres();
    }

    public void createMovies(){
        Movie avengers = new Movie();
        avengers.setMovieID(1);
        avengers.setMovieName("Avengers");
        avengers.setMovieDurationInMinutes(120);

        Movie baahubali = new Movie();
        baahubali.setMovieID(2);
        baahubali.setMovieName("Baahubali");
        baahubali.setMovieDurationInMinutes(180);

        movieController.addMovie(avengers,City.BANGALORE);
        movieController.addMovie(avengers,City.DELHI);
        movieController.addMovie(baahubali,City.DELHI);
        movieController.addMovie(baahubali,City.BANGALORE);
    }

    public void createTheatres(){

        Movie avengers = movieController.getMovie("Avengers");
        Movie baahubali = movieController.getMovie("Baahubali");

        Theatre pvr = new Theatre();
        pvr.setTheatreId(1);
        pvr.setCity(City.BANGALORE);
        pvr.setAddress("Whitefield, Oracle Office");
        pvr.setScreens(createScreens());
        List<Show> pvrShows = new ArrayList<>();
        Show pvrMorningShow = createShow(1,pvr.getScreens().get(0),avengers,12);
        Show pvrEveningShow = createShow(2,pvr.getScreens().get(0),baahubali,18);
        pvrShows.add(pvrMorningShow);
        pvrShows.add(pvrEveningShow);
        pvr.setShows(pvrShows);

        Theatre inox = new Theatre();
        inox.setTheatreId(2);
        inox.setCity(City.DELHI);
        inox.setAddress("Karol Bagh");
        inox.setScreens(createScreens());
        List<Show> inoxShows = new ArrayList<>();
        Show inoxMorningShow = createShow(1,inox.getScreens().get(0),avengers,6);
        Show inoxEveningShow = createShow(2,pvr.getScreens().get(0),baahubali,9);
        inoxShows.add(inoxMorningShow);
        inoxShows.add(inoxEveningShow);
        inox.setShows(inoxShows);

        theatreController.addTheatre(pvr,City.BANGALORE);
        theatreController.addTheatre(inox,City.DELHI);

    }

    private List<Screen> createScreens(){

        List<Screen> screens = new ArrayList<>();

        Screen screen1 = new Screen();
        screen1.setScreenID(1);
        screen1.setSeats(createSeats());
        screens.add(screen1);

        return screens;
    }

    private List<Seat> createSeats(){

        List<Seat> seats = new ArrayList<>();

        for(int i=0;i<40;i++){
            Seat seat = new Seat();
            seat.setSeatID(i);
            seat.setSeatCategory(SeatCategory.SILVER);
            seat.setPrice(200);
            seats.add(seat);
        }

        for(int i=40;i<70;i++){
            Seat seat = new Seat();
            seat.setSeatID(i);
            seat.setSeatCategory(SeatCategory.GOLD);
            seat.setPrice(300);
            seats.add(seat);
        }

        for(int i=70;i<100;i++){
            Seat seat = new Seat();
            seat.setSeatID(i);
            seat.setSeatCategory(SeatCategory.PLATINUM);
            seat.setPrice(500);
            seats.add(seat);
        }

        return seats;
    }

    public Show createShow(int showId,Screen screen,Movie movie,int startTime){

        Show show = new Show();
        show.setShowID(showId);
        show.setMovie(movie);
        show.setScreen(screen);
        show.setStartTime(startTime);

        return show;
    }

    public void createBooking(City userCity,String movieName){
        // Step 1 : Find out all the movies running in the city\
        List<Movie> moviesList = movieController.getMoviesByCity(userCity);

        // Step 2 : Check if the movie I want to watch is included in the list
        Movie interestedMovie = null;

        for(Movie movie : moviesList){
            if(movie.getMovieName().equalsIgnoreCase(movieName)){
                interestedMovie = movie;
            }
        }

        // Step 3 : Find out all the theatres and the respective shows where the movie is running
        Map<Theatre,List<Show>> theatreVsShows = theatreController.getAllShows(interestedMovie,userCity);

        // Step 4 : Choosing the theatre, I choose the first theatre.
        Map.Entry<Theatre,List<Show>> entry = theatreVsShows.entrySet().iterator().next();
        Theatre chosenTheatre = entry.getKey();
        Show chosenShow = entry.getValue().get(0);

        List<Integer> bookedSeatIDs = chosenShow.getBookedSeatIDs();

        // Step 5 : Choosing my seat number and checking if that seat has already been booked.
        int chosenSeatNumber = 30;
        if(!bookedSeatIDs.contains(chosenSeatNumber)){
           bookedSeatIDs.add(chosenSeatNumber);

           // start Payment
            Booking booking = new Booking();
            List<Seat> bookedSeats = new ArrayList<>();
            for(Seat screenSeat : chosenShow.getScreen().getSeats()){
               if(screenSeat.getSeatID() == chosenSeatNumber){
                   bookedSeats.add(screenSeat);
               }
            }

            booking.setBookedSeats(bookedSeats);
            booking.setShow(chosenShow);
        }
        else{
            System.out.println("The seat has already been booked. Please try with some other seat number");
            return;
        }

        System.out.println("BOOKING SUCCESSFUL");

    }
}
