package br.edu.utfpr.avaliacao2revisao.entidade;

import java.io.Serializable;

public class Disciplina implements Serializable {

    private int _id;
    private String disciplina;
    private Double nota;

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }
}
