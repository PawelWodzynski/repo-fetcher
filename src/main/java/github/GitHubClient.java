package github;

import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import java.util.List;

@RegisterRestClient(baseUri = "https://api.github.com")
public interface GitHubClient {
    @GET
    @Path("/users/{username}/repos")
    Uni<List<RepositoryResponse>> getRepositories(@PathParam("username") String username);

    @GET
    @Path("/repos/{owner}/{repo}/branches")
    Uni<List<BranchResponse>> getBranches(@PathParam("owner") String owner, @PathParam("repo") String repo);
}