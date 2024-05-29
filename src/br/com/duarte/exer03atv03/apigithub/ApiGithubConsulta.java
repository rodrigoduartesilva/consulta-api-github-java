package br.com.duarte.exer03atv03.apigithub;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiGithubConsulta {
    private String gitHubUser;

    public String getGitHubUser() {
        return gitHubUser;
    }

    public void setGitHubUser(String gitHubUser) {
        this.gitHubUser = gitHubUser;
    }

    private String uri = "https://api.github.com/users/" + getGitHubUser();

    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(uri))
            .build();

    HttpResponse<String> response = client
            .send(request, HttpResponse.BodyHandlers.ofString());

    public ApiGithubConsulta() throws IOException, InterruptedException {

    }

    public void ExibirPerfil() {
        System.out.println(response.body());
    }
}
