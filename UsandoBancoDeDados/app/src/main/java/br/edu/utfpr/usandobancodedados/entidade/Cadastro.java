package br.edu.utfpr.usandobancodedados.entidade;

import java.io.Serializable;

public class Cadastro implements Serializable {

    private int _id;
    private String nome;
    private String telefone;

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
