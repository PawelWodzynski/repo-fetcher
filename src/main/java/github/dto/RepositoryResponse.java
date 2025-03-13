package github.dto;

import com.fasterxml.jackson.annotation.JsonProperty;


public record RepositoryResponse(
        @JsonProperty("name") String name,
        @JsonProperty("owner") Owner owner,
        @JsonProperty("fork") boolean isFork
) {}
