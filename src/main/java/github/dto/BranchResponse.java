package github.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record BranchResponse(
        @JsonProperty("name") String name,
        @JsonProperty("commit") Commit commit
) {}
