package com.bancodigital;
import lombok.Data;
import lombok.Getter;

enum TipoConta {
    CORRENTE,
    POUPANCA
}

public abstract class Conta implements IConta {

    private static final int AGENCIA_PADRAO = 0;
    private static int SEQUENCIAL = 1;

    @Getter protected int agencia;
    @Getter protected int numero;
    @Getter protected double saldo;
    @Getter protected Cliente cliente;
    @Getter protected TipoConta tipo;

    public Conta(Cliente cliente, TipoConta tipo) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
        this.tipo = tipo;
    }

    @Override
    public void sacar(double valor) {
        saldo -= valor;
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        sacar(valor);
        contaDestino.depositar(valor);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("\tagencia: " + agencia);
        System.out.println("\tnumero: " + numero);
        System.out.println("\tnome: " + cliente.getNome());
        System.out.println("\tsaldo: " + saldo);
    }
}
