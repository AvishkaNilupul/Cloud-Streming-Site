package io.cloudvideoplayer.cloudvideoplayer.Model;

import org.springframework.data.annotation.Id;

public class FrontPageMovies {
    @Id
    private String name;
    private String location;
    private String image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
