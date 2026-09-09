//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Aluno aluno1 = new Aluno(1, "2026001", "Ana Silva", "ana@email.com", LocalDate.of(2005, 5, 20));
        Professor prof1 = new Professor(1, "RF998", "Carlos Mendes", "Mestre em Computação");
        Disciplina disc1 = new Disciplina(1, "PA101", "Programação de Aplicativos", 120);
        Curso curso1 = new Curso(1, "TDS", "Técnico em Desenvolvimento de Sistemas", 1200);

        System.out.println("Sistema de Gestão Escolar - Inicializado");
        System.out.println("Aluno matriculado: " + aluno1.getNome());
        System.out.println("Professor alocado: " + prof1.getNome());
        System.out.println("Disciplina criada: " + disc1.getNome());
    }
}