package br.com.catolica.companhia.Model;

import java.util.UUID;

public abstract class Pessoa {

    private String cpf;
    private String nome;


    public Pessoa(
                  String cpf,
                  String nome){
        this.cpf = cpf;
        this.nome = nome;
    }


    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                ", cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }
}
