package io.cloudvideoplayer.cloudvideoplayer.Services;

import io.cloudvideoplayer.cloudvideoplayer.Model.FrontPageMovies;
import io.cloudvideoplayer.cloudvideoplayer.Model.Movies;
import io.cloudvideoplayer.cloudvideoplayer.repository.FrontPageRepository;
import io.cloudvideoplayer.cloudvideoplayer.repository.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieSendService {
    @Autowired
    private FrontPageRepository frontPageRepository;
    @Autowired

    private MoviesRepository moviesRepository;
    public List<FrontPageMovies> getMovie(){
        return frontPageRepository.findMoviesByName("movie");
    }
    public List<FrontPageMovies> GetTrending(){
        return frontPageRepository.findAll();
    }
    public List<FrontPageMovies> getAnime(){
        return frontPageRepository.findMoviesByName("anime");
    }
    public List<Movies> getMovieIDS(String titles){
        return moviesRepository.findMoviesByName(titles);
    }
    public String getLocation(String title,String episode){

        return moviesRepository.findbyGenres(title,episode).get(0).getLocation();

    }
    public String getLocationMovie(String title){

        return moviesRepository.findMoviesByName(title).get(0).getLocation();

    }

    public List<Movies> getEpisodes(String title){

        return moviesRepository.findMoviesByNameAll(title);

    }



}
