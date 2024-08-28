package com.amadejsky.github_diver.service;

import com.amadejsky.github_diver.model.dto.RepositoryResponse;
import com.amadejsky.github_diver.model.dto.Response;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class GithubClientService {
    private final RestTemplate restTemplate;

    public GithubClientService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    //    public Mono<String> getUserRepositories(String username) {
//        return this.webClient.get()
//                .uri("/users/{username}/repos", username)
//                .retrieve()
//                .bodyToMono(String.class);
//    }
//public Mono<Response> getUserRepositories(String username) {
//    return this.webClient.get()
//            .uri("/users/{username}/repos", username)
//            .retrieve()
//            .bodyToMono(List.class)
//            .map(data -> new Response(
//                    username,
//                    ((List<Map<String,Object>>) data).stream()
//                            .map(repo -> (String) repo.get("name"))
//                            .collect(Collectors.toList())
//            ));
//}
    public Response getUserRepositories(String username) {
        String url = String.format("https://api.github.com/users/%s/repos", username);
        List<Map<String, Object>> response = restTemplate.getForObject(url, List.class);
        List<String> repoNames = response.stream()
                .map(repo -> (String) repo.get("name"))
                .collect(Collectors.toList());

        return new Response(username, repoNames);
    }




}
