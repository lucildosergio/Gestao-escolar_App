package br.comescola.models;

public class Espaco {
    private int id;
    private String nome;
    private int capacidade;
    private String tipo;

    public Espaco(int id, String nome, int capacidade, String tipo) {
        this.id = id;
        this.nome = nome;
        this.capacidade = capacidade;
        this.tipo = tipo;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public int getCapacidade() { return capacidade; }
    public String getTipo() { return tipo; }

    @Override
    public String toString() {
        return nome + " (" + tipo + ")";
    }
}
