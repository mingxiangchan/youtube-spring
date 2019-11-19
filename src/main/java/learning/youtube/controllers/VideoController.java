package learning.youtube.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import learning.youtube.models.Video;
import learning.youtube.repositories.VideoRepository;

@RestController
public class VideoController {

    @Autowired
    VideoRepository repo;

    @GetMapping(value = "/videos")
    public List<Video> index() {
        return repo.getAll();
    }
    
}