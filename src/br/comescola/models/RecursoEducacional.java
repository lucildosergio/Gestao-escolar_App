package br.comescola.models;

public class RecursoEducacional {
    private int id;
    private String descricao;
    private String tipo;
    private String status;
    private Espaco espaco;

    public RecursoEducacional(int id, String descricao, String tipo, String status) {
        this.id = id;
        this.descricao = descricao;
        this.tipo = tipo;
        this.status = status;
    }

    public int getId() { return id; }
    public String getDescricao() { return descricao; }
    public String getTipo() { return tipo; }
    public String getStatus() { return status; }
    public Espaco getEspaco() { return espaco; }

    public void associarEspaco(Espaco espaco) {
        this.espaco = espaco;
    }

    @Override
    public String toString() {
        return descricao + " - " + tipo + (espaco != null ? " @" + espaco.getNome() : "");
    }
}
