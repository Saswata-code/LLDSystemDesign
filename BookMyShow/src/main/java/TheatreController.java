import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheatreController {

    Map<City,List<Theatre>> cityVsTheatre;

    List<Theatre> allTheatres;

    public TheatreController(){
        cityVsTheatre = new HashMap<>();
        allTheatres = new ArrayList<>();
    }

    public void addTheatre(Theatre theatre,City city){

        allTheatres.add(theatre);

        List<Theatre> theatres = cityVsTheatre.getOrDefault(city,new ArrayList<>());
        theatres.add(theatre);

        cityVsTheatre.put(city,theatres);
    }

    public Map<Theatre,List<Show>> getAllShows(Movie interestedMovie,City userCity){

        List<Theatre> theatreListForCity = cityVsTheatre.getOrDefault(userCity,new ArrayList<>());

        Map<Theatre,List<Show>> theatreVsShows = new HashMap<>();

        for(Theatre theatre : theatreListForCity){
            for(Show show : theatre.getShows()){

                List<Show> matchedMovieShows = new ArrayList<>();

                if(show.getMovie().getMovieName().equalsIgnoreCase(interestedMovie.getMovieName())){
                    matchedMovieShows.add(show);
                    theatreVsShows.put(theatre,matchedMovieShows);
                }
            }
        }

        return theatreVsShows;
    }
}
