package io.cloudvideoplayer.cloudvideoplayer.Controllers;

import io.cloudvideoplayer.cloudvideoplayer.Model.FrontPageMovies;
import io.cloudvideoplayer.cloudvideoplayer.Model.Movies;
import io.cloudvideoplayer.cloudvideoplayer.Model.User;
import io.cloudvideoplayer.cloudvideoplayer.Model.Video;

import io.cloudvideoplayer.cloudvideoplayer.Services.AuthService;
import io.cloudvideoplayer.cloudvideoplayer.Services.MovieSendService;
import io.cloudvideoplayer.cloudvideoplayer.Services.VideoDownloader;
import io.cloudvideoplayer.cloudvideoplayer.repository.FrontPageRepository;
import io.cloudvideoplayer.cloudvideoplayer.repository.MoviesRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private VideoDownloader videoDownloader;
    @Autowired
    private MovieSendService movieSendService;
    List<Movies> movies;

    @Autowired
    AuthService authService;


    @GetMapping("/")
    public String login(HttpSession session) {
        User user =(User) session.getAttribute("user");
        if (user !=null){
            return "redirect:/home";
        }
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, HttpSession session) {

        if (authService.authenticate(username, password)) {
            User user = authService.getUserDetails(username);
            session.setAttribute("user", user);
            return "redirect:/home";

        } else {
            return "redirect:/?error=true";
        }
    }


    @GetMapping("/home")
    public String home(Model model,HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user != null){
            List<FrontPageMovies> movies = movieSendService.getMovie();
            List<FrontPageMovies> trending = movieSendService.GetTrending();
            List<FrontPageMovies> anime = movieSendService.getAnime();
            model.addAttribute("movies",movies);
            model.addAttribute("trending",trending);
            model.addAttribute("anime",anime);

            return "index";

        }else {
            return "redirect:/";
        }


    }
    @GetMapping("/test")
    public String test(){
        return "test";
    }




    @GetMapping("/download")
    public String index( Model model) {
        model.addAttribute("userForm", new Video());
        return "input";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute Video videoModel , Model model) throws IOException {
        System.out.println(videoModel.getFirstName());

        videoDownloader.VideoDownload(videoModel.getFirstName());
        model.addAttribute("userForm", new Video());
        model.addAttribute("message", "you have registered successfully.");

        return "input";
    }


    @GetMapping("/watch")
    public String watch(@RequestParam(name = "title", required = false) String title,
                        @RequestParam(name = "episode", required = false) String episode,
                        @RequestParam(name = "genres", required = false) String genres,
                        Model model) {

        movies = movieSendService.getMovieIDS(title);
        model.addAttribute("title", title);
        model.addAttribute("movies", movies);
        model.addAttribute("episode", episode);
        String location = null;
        if (genres == "movie") {
            location = movieSendService.getEpisodes(title).get(0).getLocation();

        } else {
            location = movieSendService.getLocation(title, episode);

        }


        model.addAttribute("video", "video/" + location);


        return "watch";
    }





}

