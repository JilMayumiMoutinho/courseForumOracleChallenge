package br.com.oracle.courseForum.domain.topic;

import br.com.oracle.courseForum.domain.comment.CommentDetails;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.List;

public record TopicWithCommentDetails(
        Long id,
        String title,
        String message,
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
        LocalDateTime creation_date,
        boolean status,
        String authorName,
        String courseName,
        List<CommentDetails> comments) {

    public TopicWithCommentDetails(Topic topic, List<CommentDetails> commentsReceived) {
        this(topic.getId(), topic.getTitle(),topic.getMessage(),topic.getCreation_date(),
                topic.getStatus(), topic.getAuthor().getName(), topic.getCourse().getName(), commentsReceived);
    }
}
