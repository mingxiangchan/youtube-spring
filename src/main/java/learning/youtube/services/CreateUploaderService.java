// package learning.youtube.services;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import learning.youtube.models.Uploader;
// import learning.youtube.repositories.UploaderRepository;

// @Service
// public class CreateUploaderService {
//     @Autowired
//     UploaderRepository repo;

//     public Uploader run(Uploader uploader) {
//         int existingUploader = repo.getOneByEmail(uploader.getEmail());

//         // check there isn't an existing uploader with the same title   
//         if (existingUploader == 0) {
//             repo.addUploader(uploader);
//             return uploader;
//         } else {
//             return null;
//         }
//     }
    
// }