package com.bancodigital;

public class Main {
    public static void main(String[] args) {
        // Cliente cliente = new Cliente("João");

        // Conta cc = new ContaCorrente(cliente);
        
        // cc.depositar(100);

        // cc.imprimirExtrato();
        
        // Conta cp = new ContaPoupanca(cliente);

        // cc.transferir(90, cp);

        // cc.imprimirExtrato();
        // cp.imprimirExtrato();

        Banco banco = new Banco("Bank of America");

        Cliente cliente1 = new Cliente("João");
        Cliente cliente2 = new Cliente("Maria");

        Conta cc1 = new ContaCorrente(cliente1);
        Conta cc2 = new ContaCorrente(cliente2);

        Conta cp1 = new ContaPoupanca(cliente1);
        Conta cp2 = new ContaPoupanca(cliente2);

        banco.inserirConta(cc1);
        banco.inserirConta(cc2);
        banco.inserirConta(cp1);
        banco.inserirConta(cp2);

        banco.imprimirContas();
    }
}