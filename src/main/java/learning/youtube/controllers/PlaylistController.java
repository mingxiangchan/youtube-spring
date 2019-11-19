package learning.youtube.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import learning.youtube.models.Playlist;
import learning.youtube.repositories.PlaylistRepository;

@RestController
public class PlaylistController {

    @Autowired
    PlaylistRepository repo;

    @GetMapping(value = "/playlists")
    public List<Playlist> index() {
        return repo.getAll();
    }
    
}