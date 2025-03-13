package github.api.client;

import github.dto.BranchResponse;
import github.dto.RepositoryResponse;
import io.smallrye.mutiny.Uni;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;

import java.util.List;


@RegisterRestClient(configKey = "github-api")
public interface GitHubClient {

    @GET
    @Path("/users/{username}/repos")
    @Produces("application/vnd.github+json")
    Uni<List<RepositoryResponse>> getRepositories(@PathParam("username") String username);

    @GET
    @Path("/repos/{owner}/{repo}/branches")
    @Produces("application/vnd.github+json")
    Uni<List<BranchResponse>> getBranches(@PathParam("owner") String owner, @PathParam("repo") String repo);
}