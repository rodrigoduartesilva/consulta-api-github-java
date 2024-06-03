package br.com.duarte.exer03atv03.main;

import br.com.duarte.exer03atv03.apigithub.ApiGithubConsulta;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        ApiGithubConsulta consulta = new ApiGithubConsulta();

        System.out.print("Digite o nome do usuário do GitHub: ");
        consulta.setGitHubUser(scanner.next());

        consulta.consultar();
        System.out.println(consulta.toString());
    }
}