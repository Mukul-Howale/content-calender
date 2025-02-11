package com.project.contentCalender.repository;

import com.project.contentCalender.model.Content;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
@NoArgsConstructor
@Getter
public class ContentCollectionRepository {

    private final List<Content> content = new ArrayList<>();

    public Optional<Content> findById(Integer id){
        return content.stream().filter(c -> c.id().equals(id)).findFirst();
    }
}
