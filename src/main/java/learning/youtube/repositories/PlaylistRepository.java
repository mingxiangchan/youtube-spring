package learning.youtube.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import learning.youtube.models.Playlist;

/**
 * PlaylistRepository
 */
public interface PlaylistRepository extends JpaRepository<Playlist, Long> {

    
}