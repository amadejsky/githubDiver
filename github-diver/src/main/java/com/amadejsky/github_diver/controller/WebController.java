package com.amadejsky.github_diver.controller;

import com.amadejsky.github_diver.model.dto.Response;
import com.amadejsky.github_diver.service.GithubClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/github")
public class WebController {
    private final GithubClientService githubClientService;

    public WebController(GithubClientService githubClientService) {
        this.githubClientService = githubClientService;
    }

    @GetMapping("/users/{username}")
    public Response getUserRepositories(@PathVariable String username){
        return githubClientService.getUserRepositories(username);
    }
    @GetMapping("/users/alldata/{username}")
    public ResponseEntity<String> getAllData(@PathVariable String username){
        return githubClientService.getAllData(username);
    }
}
