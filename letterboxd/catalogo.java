package letterboxd;

import java.io.*;
import java.util.*;

public class catalogo {
    public List<Filme> filmes = new ArrayList<>();

    public void adicionar (Filme filme) {
        filmes.add(filme);
    }

    public void listar() {
        if (filmes.isEmpty()){
            System.out.println("Nada no catálogo.");
        }
        else{
            for(Filme f : filmes){
                System.out.println("+f+");
            }
        }
    }

    public void buscar(String title){
        for(Filme f : filmes){
            if(f.getTitle().equalsIgnoreCase(title)){
                System.out.println("Encontrado: " + f);
                return;
            }
            else{
                System.out.println("Filme não encontrado.");
            }
        }
    }

    public void remove(String title){
        filmes.removeIf(f -> f.getTitle().equalsIgnoreCase(title));
    }

    public void salvar(String caminho) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminho))) {
            for (Filme f : filmes) {
                bw.write(f.toFileFormat());
                bw.newLine();
            }
        }
    }

    public void carregar(String caminho) throws IOException {
        filmes.clear();
        File Arquivo = new File(caminho);
        if (!Arquivo.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                Filme f = Filme.fromFileFormat(linha);
            }
        }
    }
}
