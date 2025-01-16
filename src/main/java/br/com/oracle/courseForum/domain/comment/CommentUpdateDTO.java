package br.com.oracle.courseForum.domain.comment;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CommentUpdateDTO(
        @NotBlank
        String message,
        @NotNull
        Long id,
        @NotNull
        Long author_id
) {
}
