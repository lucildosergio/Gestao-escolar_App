package br.comescola.ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import br.comescola.models.Espaco;
import br.comescola.storage.BancoMemoria;
import java.util.List;

public class EspacoForm extends JFrame {
    private JTextField tfNome = new JTextField(20);
    private JTextField tfTipo = new JTextField(15);
    private JTextField tfCapacidade = new JTextField(5);
    private DefaultTableModel tableModel;

    public EspacoForm() {
        super("Cadastro de Espa\u00E7os");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        JPanel form = new JPanel(new FlowLayout(FlowLayout.LEFT));
        form.add(new JLabel("Nome:")); form.add(tfNome);
        form.add(new JLabel("Tipo:")); form.add(tfTipo);
        form.add(new JLabel("Capacidade:")); form.add(tfCapacidade);

        JButton btnSalvar = new JButton("Salvar");
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(btnSalvar);

        tableModel = new DefaultTableModel(new Object[]{"ID","Nome","Tipo","Capacidade"},0) {
            @Override public boolean isCellEditable(int row, int column) { return false; }
        };
        JTable table = new JTable(tableModel);
        JScrollPane scroll = new JScrollPane(table);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(form, BorderLayout.NORTH);
        getContentPane().add(scroll, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        btnSalvar.addActionListener(new ActionListener(){
            @Override public void actionPerformed(ActionEvent e) {
                salvarEspaco();
            }
        });

        carregarTabela();
    }

    private void salvarEspaco() {
        String nome = tfNome.getText().trim();
        String tipo = tfTipo.getText().trim();
        String capText = tfCapacidade.getText().trim();

        if (nome.isEmpty()) { JOptionPane.showMessageDialog(this, "Nome \u00E9 obrigat\u00F3rio."); return; }
        if (tipo.isEmpty()) { JOptionPane.showMessageDialog(this, "Tipo \u00E9 obrigat\u00F3rio."); return; }
        int cap;
        try { cap = Integer.parseInt(capText); if (cap < 0) throw new NumberFormatException(); }
        catch (NumberFormatException ex) { JOptionPane.showMessageDialog(this, "Capacidade deve ser n\u00FAmero inteiro positivo."); return; }

        BancoMemoria db = BancoMemoria.getInstance();
        int id = db.listarEspacos().size() + 1;
        Espaco esp = new Espaco(id, nome, cap, tipo);
        db.adicionarEspaco(esp);
        limparFormulario();
        carregarTabela();
        JOptionPane.showMessageDialog(this, "Espa\u00E7o salvo com sucesso.");
    }

    private void limparFormulario() {
        tfNome.setText(""); tfTipo.setText(""); tfCapacidade.setText("");
    }

    private void carregarTabela() {
        tableModel.setRowCount(0);
        List<Espaco> lista = BancoMemoria.getInstance().listarEspacos();
        for (Espaco e : lista) {
            tableModel.addRow(new Object[]{e.getId(), e.getNome(), e.getTipo(), e.getCapacidade()});
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new EspacoForm().setVisible(true);
        });
    }
}
