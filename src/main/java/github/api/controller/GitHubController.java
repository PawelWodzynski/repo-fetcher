package github.api.controller;


import github.dto.ErrorResponse;
import github.service.GitHubService;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/github")
@Produces(MediaType.APPLICATION_JSON)
public class GitHubController {

    @Inject
    GitHubService gitHubService;

    @GET
    @Path("/repos/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<Response> getUserRepos(@PathParam("username") String username) {
        return gitHubService.getRepositories(username)
                .map(repos -> Response.ok(repos).build())
                .onFailure(NotFoundException.class)
                .recoverWithItem(t -> Response.status(404)
                        .entity(new ErrorResponse(404, "User not found"))
                        .build());
    }





}
