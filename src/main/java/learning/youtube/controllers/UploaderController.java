package learning.youtube.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import learning.youtube.models.Uploader;
import learning.youtube.repositories.UploaderRepository;

@RestController
public class UploaderController {

    @Autowired
    UploaderRepository repo;

    @GetMapping(value = "/uploaders")
    public List<Uploader> index() {
        return repo.getAll();
    }
    
}