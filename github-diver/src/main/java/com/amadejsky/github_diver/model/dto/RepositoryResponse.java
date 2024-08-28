package com.amadejsky.github_diver.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class RepositoryResponse {
    private String name;
    private List<Branch> branches;

    @Setter
    @Getter
    public static class Branch{
        private String name;
        private String lastCommitSha;
        private String getLastCommitMessage;

    }

}

