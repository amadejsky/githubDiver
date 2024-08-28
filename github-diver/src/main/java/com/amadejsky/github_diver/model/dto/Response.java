package com.amadejsky.github_diver.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter

public class Response {
    private String username;
    private List<String> repositories;

    public Response(String username, List<String> repositories) {
        this.username = username;
        this.repositories = repositories;
    }
}
