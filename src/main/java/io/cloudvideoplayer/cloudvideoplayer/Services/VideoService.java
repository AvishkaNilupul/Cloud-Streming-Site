package io.cloudvideoplayer.cloudvideoplayer.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class VideoService {

    private static final String FORMAT="classpath:Videos/%s.mp4";


    @Qualifier("webApplicationContext")
    @Autowired
    private ResourceLoader resourceLoader;


    public Mono<Resource> getVideo(String title){
        return Mono.fromSupplier(()->resourceLoader.
                getResource(String.format(FORMAT,title)))   ;
    }
}