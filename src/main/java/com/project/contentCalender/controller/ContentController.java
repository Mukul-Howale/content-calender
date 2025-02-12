package com.project.contentCalender.controller;

import com.project.contentCalender.model.Content;
import com.project.contentCalender.repository.ContentCollectionRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/content")
public class ContentController {

    private final ContentCollectionRepository contentCollectionRepository;

    @GetMapping("/content")
    public List<Content> findAll(){
        return contentCollectionRepository.getContent();
    }

    public Content 
}
