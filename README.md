# GitHub API Integration with Quarkus

## Project Overview

This project is a Quarkus-based application that integrates with the GitHub API to fetch repositories and branches for a given user. It is designed to be lightweight, reactive, and easily extendable.

## Features

- Fetch user repositories from GitHub
- Retrieve branches for each repository
- Filter out forked repositories
- REST API with proper error handling
- Reactive programming with Mutiny
- Structured DTOs for API responses
- Integration tests for API validation

## Technologies Used

- **Quarkus** - Fast and lightweight Java framework
- **Jakarta RESTful Web Services (JAX-RS)** - API for creating RESTful web services
- **MicroProfile Rest Client** - For making HTTP requests to GitHub API
- **SmallRye Mutiny** - Reactive programming support
- **Jackson** - JSON serialization and deserialization
- **JUnit & RestAssured** - Testing framework for integration tests

## Project Structure

src/main/java/github │── api │ ├── client │ │ ├── GitHubClient.java │ ├── controller │ │ ├── GitHubController.java │── dto │ ├── BranchResponse.java │ ├── Commit.java │ ├── ErrorResponse.java │ ├── Owner.java │ ├── RepositoryDTO.java │ ├── RepositoryResponse.java │── service │ ├── GitHubService.java │── test │ ├── GitHubControllerTest.java │── resources │ ├── application.properties


### API Endpoints

#### Get User Repositories
```http
GET /github/repos/{username}
Response Example:

[
  {
    "name": "example-repo",
    "ownerLogin": "username",
    "branches": [
      {
        "name": "main",
        "commit": { "sha": "abc123" }
      }
    ]
  }
]




Configuration
Modify application.properties with your GitHub credentials:

quarkus.rest-client.github-api.url=https://api.github.com
quarkus.rest-client.github-api.headers.Authorization=Bearer YOUR_PERSONAL_ACCESS_TOKEN
github.username=UsernameToFetch





Running the Application

Install dependencies
"mvn clean install"

Start the application
"mvn quarkus:dev"

Access API at
http://localhost:8080/github/repos/{username}

Running Tests
"mvn test"







Future Improvements

Caching of GitHub API responses
Support for additional GitHub endpoints
UI integration for displaying repository data
