package io.cloudvideoplayer.cloudvideoplayer;

import io.cloudvideoplayer.cloudvideoplayer.Model.FrontPageMovies;
import io.cloudvideoplayer.cloudvideoplayer.Model.VideoModel;

import io.cloudvideoplayer.cloudvideoplayer.Services.FrontPageMovesService;
import io.cloudvideoplayer.cloudvideoplayer.Services.VideoDownloader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;


@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private VideoDownloader videoDownloader;


    @GetMapping("/")
    public String home(Model model) {
        return "index";
    }

    @GetMapping("/download")
    public String index(Model model) {
        model.addAttribute("userForm", new VideoModel());
        return "input";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute VideoModel videoModel, Model model) throws IOException {
        System.out.println(videoModel.getFirstName());
        model.addAttribute("firstname",videoModel.getFirstName());

//        videoDownloader.VideoDownload(videoModel.getFirstName());
        model.addAttribute("userForm", new VideoModel());
        model.addAttribute("message", "you have registered successfully.");

        return "index";
    }


}
