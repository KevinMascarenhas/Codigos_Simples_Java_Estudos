package contas;

import java.util.Scanner;

public class SistemaLogin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String loginCorreto = "Usuário123";
        String senhaCorreta = "senha123";

        int tentativas = 0;
        int maxTentativas = 3;
        boolean acessoPermitido = false;

        System.out.println("---Bem Vindo ao Login---");

        while (tentativas<maxTentativas){
            System.out.println("Digite o login: ");
            String login = scanner.nextLine();

            System.out.println("Digite a senha: ");
            String senha = scanner.nextLine();

            if (login.equals(loginCorreto) && senha.equals(senhaCorreta)) {
                acessoPermitido = true;
                break;
            }
            else {
                tentativas++;
                maxTentativas = maxTentativas - tentativas;
                System.out.println("Login ou senha incorretos. Tentativas restantes: " + maxTentativas);
            }
        }

        if(acessoPermitido){
            System.out.println("Bem vindo!");
        }
        else {
            System.out.println("PÁ, ACESSO NEGADO. Tente novamente mais tarde");
        }
        scanner.close();
    }

}
