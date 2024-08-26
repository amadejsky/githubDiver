package com.amadejsky.github_diver.model;

import java.util.List;

public class Response {
    private String username;
    private List<String> repositories;

    public Response(String username, List<String> repositories) {
        this.username = username;
        this.repositories = repositories;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getRepositories() {
        return repositories;
    }

    public void setRepositories(List<String> repositories) {
        this.repositories = repositories;
    }
}
