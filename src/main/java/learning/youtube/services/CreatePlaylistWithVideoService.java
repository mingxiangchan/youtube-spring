// package learning.youtube.services;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import learning.youtube.formats.CreatePlaylistRequest;
// import learning.youtube.models.Playlist;
// import learning.youtube.models.Video;
// import learning.youtube.repositories.PlaylistRepository;
// import learning.youtube.repositories.VideoRepository;

// @Service
// public class CreatePlaylistWithVideoService {

//     @Autowired
//     PlaylistRepository playlistRepo;

//     @Autowired
//     VideoRepository videoRepo;

//     public Playlist run(CreatePlaylistRequest data) {
//         Playlist x = new Playlist();
//         x.setTitle(data.title);
//         playlistRepo.addPlaylist(x);
        
//         for (int id : data.videoIds) {
//             Video video = videoRepo.getOne(id);
//             video.setPlaylistId(x.getId());
//             videoRepo.updateVideo(video);
//         }

//         return x;
//     }
    
// }