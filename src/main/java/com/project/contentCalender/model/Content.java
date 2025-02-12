package com.project.contentCalender.model;

import java.time.LocalDateTime;

public record Content(
        String title,
        Integer id,
        String desc,
        Status status,
        Type contentType,
        LocalDateTime dateCreated,
        LocalDateTime dateUpdated,
        String url
) {
}