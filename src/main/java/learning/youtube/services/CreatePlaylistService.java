package learning.youtube.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import learning.youtube.models.Playlist;
import learning.youtube.repositories.PlaylistRepository;

@Service
public class CreatePlaylistService {
    @Autowired
    PlaylistRepository repo;

    public Playlist run(Playlist playlist) {
        int existingPlaylist = repo.getOneByTitle(playlist.getTitle());

        // check there isn't an existing playlist with the same title   
        if (existingPlaylist == 0) {
            repo.addPlaylist(playlist);
            return playlist;
        } else {
            return null;
        }
    }
    
}