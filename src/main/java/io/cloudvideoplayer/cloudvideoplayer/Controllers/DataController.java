package io.cloudvideoplayer.cloudvideoplayer.Controllers;

import io.cloudvideoplayer.cloudvideoplayer.Model.Movies;
import io.cloudvideoplayer.cloudvideoplayer.Services.MovieSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DataController {

    @Autowired
    MovieSendService movieSendService;

    @GetMapping("/trending/{id}")
    public List<Movies> getEpisodes(@PathVariable String id){
        return movieSendService.getEpisodes(id);

    }



}
