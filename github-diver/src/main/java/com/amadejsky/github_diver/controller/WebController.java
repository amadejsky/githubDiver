package com.amadejsky.github_diver.controller;

import com.amadejsky.github_diver.model.Response;
import com.amadejsky.github_diver.service.GithubClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/github")
public class WebController {
    private final GithubClientService githubClientService;

    public WebController(GithubClientService githubClientService) {
        this.githubClientService = githubClientService;
    }
//    @GetMapping("/repos/{username}")
//    public Mono<String> getUserRepositories(@PathVariable String username) {
//        return githubClientService.getUserRepositories(username);
//    }
    @GetMapping("/users/{username}")
    public Mono<Response> getUserRepositories(@PathVariable String username){
        return githubClientService.getUserRepositories(username);
    }
}
