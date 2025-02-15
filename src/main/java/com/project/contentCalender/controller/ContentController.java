package com.project.contentCalender.controller;

import com.project.contentCalender.model.Content;
import com.project.contentCalender.repository.ContentCollectionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/content")
public class ContentController {

    private final ContentCollectionRepository contentCollectionRepository;

    @GetMapping("")
    public List<Content> findAll(){
        return contentCollectionRepository.getContentList();
    }

    @GetMapping("/{id}")
    public Content findById(@PathVariable Integer id){
        return contentCollectionRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Content not found"));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(@RequestBody Content content){
        contentCollectionRepository.save(content);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("{id}")
    public void update(@RequestBody Content content, @PathVariable Integer id){
        if(!contentCollectionRepository.existsById(id))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found");
        contentCollectionRepository.save(content);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id){
        if(!contentCollectionRepository.existsById(id))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found");
        contentCollectionRepository.delete(id);
    }
}
