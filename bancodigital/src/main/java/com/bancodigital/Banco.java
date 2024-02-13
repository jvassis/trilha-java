package com.bancodigital;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private String nome;
    private List<Conta> contas;

    public Banco(String nome) {
        this.nome = nome;
        this.contas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    void inserirConta(Conta conta) {
        contas.add(conta);
    }

    void imprimirContas() {
        for (Conta conta : contas) {
            System.out.println("Agencia: " + conta.agencia + " Conta " + conta.getTipo() +  " Numero: " + conta.numero + " Cliente: " + conta.cliente.getNome());
        }
    }

}
