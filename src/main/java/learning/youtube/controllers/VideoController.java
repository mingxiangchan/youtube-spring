package learning.youtube.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import learning.youtube.models.Playlist;
import learning.youtube.models.Video;
import learning.youtube.repositories.PlaylistRepository;
import learning.youtube.repositories.VideoRepository;


@RestController
public class VideoController {

    @Autowired
    VideoRepository videoRepo;

    @Autowired
    PlaylistRepository playlistRepo;

    @GetMapping(value = "/videos")
    public List<Video> index() {
        List<Video> videos =  videoRepo.findAll();
        return videos;
    }

    @GetMapping(value = "/videos/{id}")
    public Video show(@PathVariable("id") Long id){
        return videoRepo.findById(id).orElse(null);
    }
    
    @PostMapping(value="/videos")
    public Video create(
        @RequestBody Video video, 
        @RequestParam(name = "playlistId"
    ) Long playlistId) {
        Playlist playlist = playlistRepo.findById(playlistId).orElse(null);

        if (playlist == null) {
            return null;
        }

        playlist.addVideo(video);
        videoRepo.save(video);
        return video;
    }
    
    // @PostMapping(value = "/videos/{id}")
    // public void update(@PathVariable("id") int id, @RequestBody Video newVideo){
    //     newVideo.setId(id);
    //     // Find existinig video using video d
    //     // update video with existing video information
    //     repo.updateVideo(newVideo);
    // }

    // @DeleteMapping(value = "/videos/{id}")
    // public String update(@PathVariable("id") int id){
    //     if(repo.videoExists(id)){
    //         repo.deleteVideo(id);
    //         return "Sucessfully deleted video";
    //     } else {
    //         return "Video could not be found";
    //     }
    // }
}