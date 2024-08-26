package com.amadejsky.github_diver.service;

import com.amadejsky.github_diver.model.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class GithubClientService {
    private final WebClient webClient;

    public GithubClientService(WebClient webClient) {
        this.webClient = webClient;
    }
//    public Mono<String> getUserRepositories(String username) {
//        return this.webClient.get()
//                .uri("/users/{username}/repos", username)
//                .retrieve()
//                .bodyToMono(String.class);
//    }
public Mono<Response> getUserRepositories(String username) {
    return this.webClient.get()
            .uri("/users/{username}/repos", username)
            .retrieve()
            .bodyToMono(List.class)
            .map(data -> new Response(
                    username,
                    ((List<Map<String,Object>>) data).stream()
                            .map(repo -> (String) repo.get("name"))
                            .collect(Collectors.toList())
            ));
}





}
