package learning.youtube.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import learning.youtube.models.Video;
import learning.youtube.repositories.VideoRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class VideoController {

    @Autowired
    VideoRepository repo;

    @GetMapping(value = "/videos")
    public List<Video> index() {
        return repo.getAll();
    }

    @GetMapping(value = "/videos/{id}")
    public Video show(@PathVariable("id") int id){
        return repo.getOne(id);
    }
    
    @PostMapping(value="/videos")
    public Video create(@RequestBody Video video) {
        repo.addVideo(video);        
        return video;
    }
    
    @PostMapping(value = "/videos/{id}")
    public void update(@PathVariable("id") int id, @RequestBody Video newVideo){
        newVideo.setId(id);
        // Find existinig video using video d
        // update video with existing video information
        repo.updateVideo(newVideo);
    }

    @DeleteMapping(value = "/videos/{id}")
    public String update(@PathVariable("id") int id){
        if(repo.videoExists(id)){
            repo.deleteVideo(id);
            return "Sucessfully deleted video";
        } else {
            return "Video could not be found";
        }
    }
}