package br.com.oracle.courseForum.domain.topic.validations;

import br.com.oracle.courseForum.domain.topic.TopicCreationDTO;
import br.com.oracle.courseForum.infra.exception.ValidationInput;
import org.apache.coyote.BadRequestException;

public interface ValidationTopicCreation {
    void validate(TopicCreationDTO topicData);
}
