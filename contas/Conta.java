package contas;

import java.util.Scanner;

public class Conta {

    double saldo;
    int agencia;
    int numero;
    int escolha;
    String titular;
    String entrada = "Bem vindo!";
    Scanner scanner;
    boolean saca;


    public void deposita(double valor) {
        this.saldo = this.saldo + valor;
    }

    public boolean saca(double valor) {
        if (this.saldo >= valor){
            this.saldo = this.saldo - valor;
            return true;
        }
        else{
            System.out.println("Não foi possível efetuar a operação.");
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println("---Bem vindo---");
        System.out.println("O que você deseja? 1 - Consultar Valor 2 - Sacar 3 - Depositar");
    }

}