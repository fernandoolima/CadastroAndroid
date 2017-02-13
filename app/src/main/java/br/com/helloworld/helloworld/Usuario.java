package br.com.helloworld.helloworld;

import java.io.Serializable;

/**
 * Created by 15251366 on 06/02/2017.
 */

public class Usuario implements Serializable{

    private String nome;
    private String senha;
    private String email;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
