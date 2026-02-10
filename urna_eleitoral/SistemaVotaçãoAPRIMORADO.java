package urna_eleitoral;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SistemaVotaçãoAPRIMORADO {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Candidato> candidatoes = new ArrayList<>();
        candidatoes.add(new Candidato("Tarcisio de Freitas", 10, "Republicanos", 0));
        candidatoes.add(new Candidato("Lula", 13, "PT", 0));
        candidatoes.add(new Candidato("Michelle Bolsonaro", 22, "PL", 0));
        candidatoes.add(new Candidato("Ronaldo Caiado", 25, "União Brasil", 0));
        candidatoes.add(new Candidato("Romeu Zema", 30, "Novo", 0));
        candidatoes.add(new Candidato("Ciro Gomes", 45, "PSDB", 0));
        candidatoes.add(new Candidato("Guilherme Boulos", 50, "PSOL", 0));
        candidatoes.add(new Candidato("Ratinho Jr.", 55, "PSD", 0));
        candidatoes.add(new Candidato("Renan Santos", 14, "Missão", 0));

        int brancos = 0;
        int nulos = 0;
        boolean votando = true;

        while (votando) {
            System.out.println("Digite seu voto (ou -1 para encerrar): ");
            int votos = scanner.nextInt();

            if (votos == -1) {
                break;
            } else if (votos == 0) {
                brancos++;
                System.out.println("Voto em branco computado.");
            } else {
                boolean encontrou = false;
                for (Candidato c : candidatoes) {
                    if (c.numero == votos) {
                        c.votos++;
                        System.out.println("Voto computado para " + c.nome + " (" + c.partido + ")");
                        encontrou = true;
                        break;
                    }
                }
                if (!encontrou) {
                    nulos++;
                    System.out.println("Voto nulo computado.");
                }
            }
        }
        Collections.sort(candidatoes);

        System.out.println("\n=== Resultado da Votação ===");
        for (Candidato c : candidatoes) {
            System.out.println(c.nome + " (" + c.partido + "): " + c.votos + " votos");
        }
        System.out.println("Brancos: " + brancos);
        System.out.println("Nulos: " + nulos);

        scanner.close();
    }
}


