package br.com.oracle.courseForum.domain.comment;

import br.com.oracle.courseForum.domain.topic.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Topic, Long> {
    @Query("""
            SELECT new br.com.oracle.courseForum.domain.comment.CommentDetails(
                m.id, m.message, m.resolve, a.name, a.id
            )
            FROM Comment m
            JOIN m.author a
            WHERE m.topic.id = :topic_id
            """)
    List<CommentDetails> findAllByTopicId(Long topic_id);
}
