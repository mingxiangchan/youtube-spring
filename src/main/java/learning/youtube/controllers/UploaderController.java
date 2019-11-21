package learning.youtube.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import learning.youtube.models.Uploader;
import learning.youtube.repositories.UploaderRepository;
import learning.youtube.services.CreateUploaderService;

@RestController
public class UploaderController {

    @Autowired
    UploaderRepository repo;

    @Autowired
    CreateUploaderService createUploaderService;

    @GetMapping(value = "/uploaders")
    public List<Uploader> index() {
        return repo.getAll();
    }

    @PostMapping(value = "/uploaders")
    public Uploader create(@RequestBody Uploader uploader){
        return createUploaderService.run(uploader);
    }    
    
    @GetMapping(value = "/uploaders/{id}")
    public Uploader show(@PathVariable("id") int id){
        return repo.getOne(id);
    }

    @PostMapping(value = "/uploaders/{id}")
    public void update(@PathVariable("id") int id, @RequestBody Uploader uploader){
        uploader.setId(id);
        repo.updateUploader(uploader);
    }

    @DeleteMapping(value = "/uploaders/{id}")
    public String update(@PathVariable("id") int id){
        if(repo.uploaderExists(id)){
            repo.deleteUploader(id);
            return "Sucessfully deleted uploader";
        } else {
            return "Uploader could not be found";
        }
    }
}