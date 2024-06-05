package io.cloudvideoplayer.cloudvideoplayer.repository;

import io.cloudvideoplayer.cloudvideoplayer.Model.FrontPageMovies;
import io.cloudvideoplayer.cloudvideoplayer.Model.Movies;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface FrontPageRepository extends MongoRepository<FrontPageMovies,String> {
    @Query("{'genres': ?0}")
    List<FrontPageMovies> findMoviesByName(String genres);




}
