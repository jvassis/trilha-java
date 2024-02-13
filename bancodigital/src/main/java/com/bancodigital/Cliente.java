package com.bancodigital;

import lombok.Getter;

public class Cliente {
    @Getter private String nome;

    public Cliente(String nome) {
        this.nome = nome;
    }
}
