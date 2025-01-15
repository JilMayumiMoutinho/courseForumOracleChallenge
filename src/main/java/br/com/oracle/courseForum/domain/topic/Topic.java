package br.com.oracle.courseForum.domain.topic;

import br.com.oracle.courseForum.domain.course.Course;
import br.com.oracle.courseForum.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "topics")
@Entity(name = "Topic")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private User author;
    private String title;
    private String message;
    private LocalDateTime creation_date;
    private Boolean status;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;

    public Topic(User userReceived, Course courseReceived, TopicCreationDTO topicData){
        this.author = userReceived;
        this.course = courseReceived;
        this.creation_date = LocalDateTime.now();
        this.title = topicData.title();
        this.message = topicData.message();
        this.status = true;
    }

    /*public void setAsResolved() {
        this.status = false;
    }*/

    @Override
    public String toString() {
        return "Title" + title + '\'' +
                ", author=" + author +
                ", message='" + message + '\'' +
                ", creation date=" + creation_date +
                ", status=" + status +
                ", course=" + course +
                '}';
    }
}
