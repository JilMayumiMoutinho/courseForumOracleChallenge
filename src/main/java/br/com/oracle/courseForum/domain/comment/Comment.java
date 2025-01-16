package br.com.oracle.courseForum.domain.comment;

import br.com.oracle.courseForum.domain.topic.Topic;
import br.com.oracle.courseForum.domain.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
@Table(name = "comments")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;

    @Setter
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "topic_id")
    private Topic topic;

    @Setter
    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

    private LocalDateTime creation_date;
    @Setter
    private boolean resolve;

    public Comment(CommentCreationDTO data, User author, Topic topic) {
        this.message = data.message();
        this.creation_date = LocalDateTime.now();
        this.author = author;
        this.topic = topic;
        this.resolve = false;
    }

    public void updateComment(CommentUpdateDTO data) {
        this.message = data.message();
    }

    public void setAsSolution() {
        this.resolve = true;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "topic=" + topic.getId() +
                ", message='" + message + '\'' +
                ", author=" + author.getName() +
                ", creation_date=" + creation_date +
                ", was the solution=" + resolve +
                '}';
    }

    public boolean getResolve() {return resolve;}
}
