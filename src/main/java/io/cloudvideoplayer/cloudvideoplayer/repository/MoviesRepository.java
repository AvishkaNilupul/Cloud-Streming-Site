package io.cloudvideoplayer.cloudvideoplayer.repository;

import io.cloudvideoplayer.cloudvideoplayer.Model.FrontPageMovies;
import io.cloudvideoplayer.cloudvideoplayer.Model.Movies;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface MoviesRepository extends MongoRepository<Movies,String> {
    @Query("{'name': ?0, 'episode': ?1}")
    List<Movies> findbyGenres(String name,String episode);

    @Query("{'name': ?0}")
    List<Movies> findMoviesByName(String name);
    @Query("{'name': { $regex: ?0, $options: 'i' }}")
    List<Movies> findMoviesByNameAll(String name);


}
