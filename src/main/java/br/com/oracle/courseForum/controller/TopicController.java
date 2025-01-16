package br.com.oracle.courseForum.controller;

import br.com.oracle.courseForum.domain.comment.CommentRepository;
import br.com.oracle.courseForum.domain.topic.*;
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

    @Autowired
    private CommentRepository commentRepository;

    @PostMapping("/create")
    @Transactional
    public ResponseEntity create(@RequestBody @Valid TopicCreationDTO topicData, UriComponentsBuilder uriBuilder){
        var topic = topicService.createTopic(topicData);
        var location = uriBuilder.path("/topics/{id}").buildAndExpand(topic.getId()).toUri();
        return ResponseEntity.created(location).body(topic);
    }

    @GetMapping
    public ResponseEntity<Page<TopicDetails>> getTopicsPagination(@PageableDefault(size = 10, sort = {"creation_date"}) Pageable pageable) {
        var topicsPage = topicRepository.findAllJoiningAuthorAndCourse(pageable);//.map(TopicDetails::new);
        return ResponseEntity.ok(topicsPage);
    }

    @GetMapping("/{id}")
    public ResponseEntity getTopic(@PathVariable Long id){
        var topic = topicRepository.getReferenceById(id);
        var comments = commentRepository.findAllByTopicId(id);
        var topicWithComment = new TopicWithCommentDetails(topic, comments);

        return ResponseEntity.ok(topicWithComment);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity updateTopic(@RequestBody @Valid TopicUpdateDTO topicData, @PathVariable Long id){
        var topic = topicService.updateTopic(topicData);
        return ResponseEntity.ok(topic);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteTopic(@PathVariable Long id) {
        var topic = topicRepository.getReferenceById(id);
        topicRepository.delete(topic);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/solved/{id}")
    @Transactional
    public ResponseEntity solveTopic(@PathVariable Long id) {
        var topic = topicRepository.getReferenceById(id);
        topic.resolveTopic();
        topicRepository.save(topic);

        return ResponseEntity.noContent().build();
    }
}
