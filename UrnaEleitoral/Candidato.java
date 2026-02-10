package UrnaEleitoral;

public class Candidato implements Comparable<Candidato> {
    String nome;
    int numero;
    String partido;
    int votos;

    public Candidato(String nome, int numero, String partido, int votos){
        this.nome = nome;
        this.numero = numero;
        this.partido = partido;
        this.votos = votos;
    }

    @Override
    public int compareTo(Candidato outro){
        return Integer.compare(outro.votos, this.votos);
    }
}
