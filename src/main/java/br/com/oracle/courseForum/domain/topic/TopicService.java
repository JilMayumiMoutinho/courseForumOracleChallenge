package br.com.oracle.courseForum.domain.topic;

import br.com.oracle.courseForum.domain.course.CourseRepository;
import br.com.oracle.courseForum.domain.topic.validations.ValidationTopicCreation;
import br.com.oracle.courseForum.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {
    @Autowired
    private List<ValidationTopicCreation> topicCreationValidators;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private CourseRepository courseRepository;

    public TopicDetails createTopic(TopicCreationDTO topicData) {
        topicCreationValidators.forEach(v -> v.validate(topicData));

        var author = userRepository.findById(topicData.userId()).get();
        var course = courseRepository.findById(topicData.couseId()).get();
        var topic = new Topic(author, course, topicData);
        var createdTopic = topicRepository.save(topic);
        return new TopicDetails(
                createdTopic.getId(),
                createdTopic.getTitle(),
                createdTopic.getMessage(),
                createdTopic.getCreation_date(),
                createdTopic.getStatus(),
                createdTopic.getAuthor().getName(),
                createdTopic.getCourse().getName()
        );
    }
}

