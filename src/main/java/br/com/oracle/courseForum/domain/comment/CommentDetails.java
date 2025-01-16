package br.com.oracle.courseForum.domain.comment;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CommentDetails(
        @NotNull
        Long id,
        @NotBlank
        String message,
        @NotNull
        boolean resolve,
        @NotNull
        String authorName,
        @NotNull
        Long authorId
) {
}
