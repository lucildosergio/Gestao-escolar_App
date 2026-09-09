package br.comescola.storage;

import java.util.ArrayList;
import java.util.List;
import br.comescola.models.Espaco;
import br.comescola.models.RecursoEducacional;

public class BancoMemoria {
    private static BancoMemoria instancia;
    private List<Espaco> espacos = new ArrayList<>();
    private List<RecursoEducacional> recursos = new ArrayList<>();

    private BancoMemoria() {}

    public static BancoMemoria getInstance() {
        if (instancia == null) instancia = new BancoMemoria();
        return instancia;
    }

    public void adicionarEspaco(Espaco e) { espacos.add(e); }
    public List<Espaco> listarEspacos() { return new ArrayList<>(espacos); }

    public void adicionarRecurso(RecursoEducacional r) { recursos.add(r); }
    public List<RecursoEducacional> listarRecursos() { return new ArrayList<>(recursos); }
}
