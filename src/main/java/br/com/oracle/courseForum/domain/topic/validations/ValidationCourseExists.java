package br.com.oracle.courseForum.domain.topic.validations;

import br.com.oracle.courseForum.domain.topic.TopicCreationDTO;
import br.com.oracle.courseForum.domain.user.UserRepository;
import br.com.oracle.courseForum.infra.exception.ValidationInput;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;


public class ValidationCourseExists implements ValidationTopicCreation {
        @Autowired
        private UserRepository userRepository;

        @Override
        public void validate(TopicCreationDTO topicData) throws ValidationInput {
            if(!userRepository.existsById(topicData.userId())){
                throw new ValidationInput("Id do paciente informado não existe!");
            }
        }
    }