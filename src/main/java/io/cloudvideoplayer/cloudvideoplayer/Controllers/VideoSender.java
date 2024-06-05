package io.cloudvideoplayer.cloudvideoplayer.Controllers;

import io.cloudvideoplayer.cloudvideoplayer.Model.FrontPageMovies;
import io.cloudvideoplayer.cloudvideoplayer.Services.VideoService;
import io.cloudvideoplayer.cloudvideoplayer.repository.FrontPageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class VideoSender {

    @Autowired
    private VideoService service;


    @GetMapping(value = "video/{title}", produces = "video/mp4")
    public Mono<Resource> getVideos(@PathVariable String title, @RequestHeader("Range") String range) {
        return service.getVideo(title);
    }



    @Autowired
    private FrontPageRepository frontPageRepository;
    @GetMapping("/frontpage")
    public List<FrontPageMovies> getMovies(){
        return  frontPageRepository.findAll();
    }



}
