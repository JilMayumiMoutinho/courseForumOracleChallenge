package br.com.oracle.courseForum.controller;

import br.com.oracle.courseForum.domain.topic.TopicCreationDTO;
import br.com.oracle.courseForum.domain.topic.TopicDetails;
import br.com.oracle.courseForum.domain.topic.TopicRepository;
import br.com.oracle.courseForum.domain.topic.TopicService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topics/info")
public class TopicController {
    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private TopicService topicService;

    @PostMapping("/create")
    @Transactional
    public ResponseEntity create(@RequestBody @Valid TopicCreationDTO topicData, UriComponentsBuilder uriBuilder){
        var topic = topicService.createTopic(topicData);
        var location = uriBuilder.path("/topics/{id}").buildAndExpand(topic.getId()).toUri();
        return ResponseEntity.created(location).body(topic);
    }

    @GetMapping
    public ResponseEntity<Page<TopicDetails>> getTopics(@PageableDefault(size = 10, sort = {"creation_date"}) Pageable pageable) {
        var topicsPage = topicRepository.findAllJoiningAuthorAndCourse(pageable);//.map(TopicDetails::new);
        return ResponseEntity.ok(topicsPage);
    }
}
