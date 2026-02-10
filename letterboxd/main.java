package letterboxd;

import java.io.IOException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        catalogo catalogo = new catalogo();
        Scanner scanner = new Scanner(System.in);
        String caminhoArquivo = "filmes.txt";

        try {
            catalogo.carregar(caminhoArquivo);
        } catch (IOException e) {
            throw new RuntimeException(e);
            System.out.println("Erro ao carregar arquivo");
        }

        int opcao;

        do {
            System.out.println("-----BEM VINDO AO LETTERBOXD DO FEIRAGUAY-----");
            System.out.println("\n1. Adicionar filme");
            System.out.println("2. Listar filmes");
            System.out.println("3. Buscar filme");
            System.out.println("4. Remover filme");
            System.out.println("5. Salvar e sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            switch (opcao){
                case 1:
                    System.out.println("Título: ");
                    String title = scanner.nextLine();
                    System.out.println("Diretor: ");
                    String director = scanner.nextLine();
                    System.out.println("Duração: ");
                    int duration = scanner.nextInt();
                    System.out.println("Ano: ");
                    int year = scanner.nextInt();

                    catalogo.adicionar(new Filme(title, director, duration, year));
                    break;
                case 2:
                    catalogo.listar();
                    break;
                case 3:
                    System.out.println("Digite o título do filme: ");
                    String busca = scanner.nextLine();
                    catalogo.buscar(busca);
                    break;
                case 4:
                    System.out.println("Digite o título do filme que busca remover: ");
                    String remover = scanner.nextLine();
                    catalogo.remove(remover);
                case 5:
                    try {
                        catalogo.salvar(caminhoArquivo);
                        System.out.println("Filmes salvos com sucesso.");
                    } catch (IOException e) {
                        System.out.println("Erro ao salvar arquivo.");
                    }
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
        while(opcao != 5);
    }
}
