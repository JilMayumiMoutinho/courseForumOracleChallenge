package br.com.oracle.courseForum.domain.topic;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TopicCreationDTO (
        @NotBlank(message = "Title is required")
        String title,
        @NotBlank(message = "Message is required")
        String message,
        @NotNull(message="Author is required")
        Long userId,
        @NotNull(message="Course is required")
        Long courseId
){
}
