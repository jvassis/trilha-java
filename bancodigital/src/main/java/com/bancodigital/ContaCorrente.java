package com.bancodigital;

public class ContaCorrente extends Conta {
    public ContaCorrente(Cliente cliente) {
        super(cliente, TipoConta.CORRENTE);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("\n> conta corrente");
        super.imprimirExtrato();
    }
}
