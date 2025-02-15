package com.project.contentCalender.repository;

import com.project.contentCalender.model.Content;
import com.project.contentCalender.model.Status;
import com.project.contentCalender.model.Type;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
@NoArgsConstructor
@Getter
public class ContentCollectionRepository {

    private final List<Content> contentList = new ArrayList<>();

    public Optional<Content> findById(Integer id){
        return contentList.stream().filter(c -> c.id().equals(id)).findFirst();
    }

    public void createContent(Content content){
        contentList.add(content);

    }

    @PostConstruct
    private void init() {
        Content content = new Content (1,
                "My First Blog Post",
                "My first blog post",
                Status.IDEA,
                Type.ARTICLE,
                LocalDateTime.now(),
                null,
                "");

        contentList.add(content);
    }
}
