package com.project.contentCalender.controller;

import com.project.contentCalender.model.Content;
import com.project.contentCalender.repository.ContentCollectionRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/content")
public class ContentController {

    private final ContentCollectionRepository contentCollectionRepository;

    @GetMapping("")
    public List<Content> findAll(){
        return contentCollectionRepository.getContent();
    }

    public Content findById(Integer id){
        Optional<Content> content = contentCollectionRepository.findById(id);
        return content.orElse(null);
    }
}
