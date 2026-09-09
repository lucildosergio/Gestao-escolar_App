package br.comescola.models;

public class Disciplina {
    private int id;
    private String codigo;
    private String nome;
    private int cargaHoraria;

    public Disciplina(int id, String codigo, String nome, int cargaHoraria) {
        this.id = id;
        this.codigo = codigo;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
    }

    public String getNome() { return nome; }
}