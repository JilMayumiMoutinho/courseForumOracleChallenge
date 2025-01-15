package br.com.oracle.courseForum.domain.topic;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TopicRepository extends JpaRepository<Topic, Long> {
    @Query("""
        SELECT new br.com.oracle.courseForum.domain.topic.TopicDetails(
        t.id, t.title, t.message, t.creation_date, t.status, a.name, c.name)
        FROM Topic t
        JOIN t.author a
        JOIN t.course c
        """)
    Page<TopicDetails> findAllJoiningAuthorAndCourse(Pageable pageable);
}
