package br.com.oracle.courseForum.domain.topic.validations;

import br.com.oracle.courseForum.domain.topic.TopicCreationDTO;

public interface ValidationTopicCreation {
    void validate(TopicCreationDTO topicData);
}
