package br.com.duarte.exer03atv03.apigithub;

import br.com.duarte.exer03atv03.model.UserGitHub;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiGithubConsulta {
    private String gitHubUser;
    private String jsonBody;
    private UserGitHub searchUser;
    private String endereco;

    public String getGitHubUser() {
        return gitHubUser;
    }

    public void setGitHubUser(String gitHubUser) {
        this.gitHubUser = gitHubUser;
    }

    public void consultar() throws IOException, InterruptedException {
        endereco = "https://api.github.com/users/" + getGitHubUser();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        jsonBody = response.body();

        Gson gson = new Gson();
        searchUser = gson.fromJson(jsonBody, UserGitHub.class);
    }

    public ApiGithubConsulta() throws IOException, InterruptedException {

    }

    @Override
    public String toString() {
        return """
               
               Json: %s
               
               Endereço: %s
               
               Valor Digitado: %s
               
               -----------------------------------------------------------------------------------
               
               Nome: %s
               Login: %s
               Id: %s
               URL: %s
            
                
               """.formatted(jsonBody, endereco, getGitHubUser(), searchUser.getName(), searchUser.getLogin(),
                        searchUser.getId(), searchUser.getHtml_url());
    }
}
