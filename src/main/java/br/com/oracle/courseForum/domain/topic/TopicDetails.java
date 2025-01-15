package br.com.oracle.courseForum.domain.topic;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record TopicDetails(
        Long id,
        String title,
        String message,
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
        LocalDateTime creation_date,
        boolean status,
        String authorName,
        String courseName

) {
        public TopicDetails(Long id, String title, String message, @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
        LocalDateTime creation_date, boolean status, String authorName, String courseName) {
                this.id = id;
                this.title = title;
                this.message = message;
                this.creation_date = creation_date;
                this.authorName = authorName;
                this.courseName = courseName;
                this.status = status;
        }

        public Long getId() {
                return id;
        }
}
