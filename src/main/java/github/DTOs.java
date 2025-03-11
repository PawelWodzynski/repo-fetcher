package github;

import java.util.List;

record RepositoryResponse(String name, Owner owner, boolean fork) {
    public boolean isFork() {
        return fork;
    }
}
record Owner(String login) {}
record BranchResponse(String name, Commit commit) {}
record Commit(String sha) {}
record RepositoryDTO(String name, String ownerLogin, List<BranchResponse> branches) {}

