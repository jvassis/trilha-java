package com.bancodigital;

public class ContaPoupanca extends Conta {
    public ContaPoupanca(Cliente cliente) {
        super(cliente, TipoConta.POUPANCA);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("\n> conta poupanca");
        super.imprimirExtrato();
    }
}
