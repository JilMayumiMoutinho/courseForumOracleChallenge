package br.com.oracle.courseForum.domain.comment;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CommentCreationDTO(
        @NotBlank
        String message,
        @NotNull
        Long topic_id,
        @NotNull
        Long author_id
) {
}
