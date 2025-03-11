package github;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class GitHubService {

    @Inject
    @RestClient
    GitHubClient gitHubClient;

    public Uni<List<RepositoryDTO>> getRepositories(String username) {
        return gitHubClient.getRepositories(username)
                .onItem().transform(repos ->
                        repos.stream()
                                .filter(repo -> !repo.isFork()) // Filtrujemy tylko nie-forki
                                .map(repo ->
                                        gitHubClient.getBranches(repo.owner().login(), repo.name())
                                                .map(branches -> new RepositoryDTO(repo.name(), repo.owner().login(), branches))
                                )
                                .collect(Collectors.toList())
                )
                .flatMap(uniList -> Uni.join().all(uniList).andCollectFailures()
                        .onItem().transform(list -> list.stream()
                                .filter(result -> result != null)
                                .collect(Collectors.toList())
                        )
                );
    }
}
