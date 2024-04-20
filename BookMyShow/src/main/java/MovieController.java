import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MovieController {

    Map<City,List<Movie>> cityVsMovie;

    List<Movie> allMovies;

    public MovieController(){
        cityVsMovie = new HashMap<>();
        allMovies = new ArrayList<>();
    }

    public void addMovie(Movie movie, City city){

        allMovies.add(movie);

        List<Movie> movies = cityVsMovie.getOrDefault(city,new ArrayList<>());
        movies.add(movie);
        cityVsMovie.put(city,movies);
    }

    public Movie getMovie(String movieName){
        Movie movie = allMovies.stream()
                                .filter((movieItem) -> movieItem.getMovieName().equalsIgnoreCase(movieName))
                                .collect(Collectors.toList()).get(0);

        return movie;
    }

    public List<Movie> getMoviesByCity(City userCity){
        return cityVsMovie.getOrDefault(userCity,new ArrayList<>());
    }
}
