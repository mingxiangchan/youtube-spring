package learning.youtube.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import learning.youtube.models.Video;

public interface VideoRepository extends JpaRepository<Video, Long> {

    
}