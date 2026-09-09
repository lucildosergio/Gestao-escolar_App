package br.comescola.models;

public class Horario {
    private int id;
    private String diaSemana;
    private String horaInicio;
    private String horaFim;

    public Horario(int id, String diaSemana, String horaInicio, String horaFim) {
        this.id = id;
        this.diaSemana = diaSemana;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
    }

    public int getId() { return id; }
    public String getDiaSemana() { return diaSemana; }
    public String getHoraInicio() { return horaInicio; }
    public String getHoraFim() { return horaFim; }
}
