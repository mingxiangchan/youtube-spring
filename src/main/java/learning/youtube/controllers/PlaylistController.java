package learning.youtube.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import learning.youtube.formats.CreatePlaylistRequest;
import learning.youtube.models.Playlist;
import learning.youtube.repositories.PlaylistRepository;
import learning.youtube.services.CreatePlaylistService;
import learning.youtube.services.CreatePlaylistWithVideoService;

@RestController
public class PlaylistController {

    @Autowired
    PlaylistRepository repo;

    @Autowired
    CreatePlaylistService createPlaylistService;

    @Autowired
    CreatePlaylistWithVideoService createPlaylistWithVideoService;

    @GetMapping(value = "/playlists")
    public List<Playlist> index() {
        return repo.getAll();
    }

    @PostMapping(value = "/playlists")
    public Playlist create(@RequestBody Playlist playlist){
        return createPlaylistService.run(playlist);
    }

    @PostMapping(value = "/playlists/with_videos")
    public Playlist createWithVideos(@RequestBody CreatePlaylistRequest data) {
        return createPlaylistWithVideoService.run(data);
    }

    @GetMapping(value = "/playlists/{id}")
    public Playlist show(@PathVariable("id") int id){
        return repo.getOne(id);
    }

    @PostMapping(value = "/playlists/{id}")
    public void update(@PathVariable("id") int id, @RequestBody Playlist playlist){
        playlist.setId(id);
        repo.updatePlaylist(playlist);
    }

    @DeleteMapping(value = "/playlists/{id}")
    public String update(@PathVariable("id") int id){
        if(repo.playlistExists(id)){
            repo.deletePlaylist(id);
            return "Sucessfully deleted playlist";
        } else {
            return "Playlist could not be found";
        }
    }
}
