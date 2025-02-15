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

    @PostMapping("")
    public void createContent(@RequestBody Content content){
        contentCollectionRepository.createContent(content);
    }
}
