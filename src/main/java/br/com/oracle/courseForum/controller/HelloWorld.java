package br.com.oracle.courseForum.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloWorld {

    @GetMapping
    public String helloWorld() {
        return "Hello world 1321313AAAAAAAAAA";
    }
}
