package github.api.controller;

import io.quarkus.test.junit.QuarkusTest;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


@QuarkusTest
public class GitHubControllerTest {

    @ConfigProperty(name = "github.username")
    String username;

    @Test
    public void testGetUserReposHappyPath() {
        given()
                .pathParam("username", username)
                .when()
                .get("/github/repos/{username}")
                .then()
                .statusCode(200)
                .contentType("application/json")
                .log().all()
                .body("[0].name", notNullValue())
                .body("[0].ownerLogin", notNullValue())
                .body("[0].branches.size()", greaterThan(0))
                .body("[0].branches[0].name", notNullValue())
                .body("[0].branches[0].commit.sha", notNullValue());
    }

}



