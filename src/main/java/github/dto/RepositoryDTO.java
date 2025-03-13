package github.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;


public record RepositoryDTO(
        @JsonProperty("name") String name,
        @JsonProperty("ownerLogin") String ownerLogin,
        @JsonProperty("branches") List<BranchResponse> branches
) {}


