package br.comescola.ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import br.comescola.models.Espaco;
import br.comescola.models.RecursoEducacional;
import br.comescola.storage.BancoMemoria;

public class RecursoForm extends JFrame {
    private JTextField tfDescricao = new JTextField(20);
    private JTextField tfTipo = new JTextField(15);
    private JTextField tfStatus = new JTextField(10);
    private JComboBox<Espaco> cbEspaco = new JComboBox<>();
    private DefaultTableModel tableModel;

    public RecursoForm() {
        super("Cadastro de Recursos Educacionais");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(700, 400);
        setLocationRelativeTo(null);

        JPanel form = new JPanel(new FlowLayout(FlowLayout.LEFT));
        form.add(new JLabel("Descri\u00E7\u00E3o:")); form.add(tfDescricao);
        form.add(new JLabel("Tipo:")); form.add(tfTipo);
        form.add(new JLabel("Status:")); form.add(tfStatus);
        form.add(new JLabel("Espa\u00E7o:")); form.add(cbEspaco);

        JButton btnSalvar = new JButton("Salvar");
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(btnSalvar);

        tableModel = new DefaultTableModel(new Object[]{"ID","Descri\u00E7\u00E3o","Tipo","Status","Espa\u00E7o"},0) {
            @Override public boolean isCellEditable(int row, int column) { return false; }
        };
        JTable table = new JTable(tableModel);
        JScrollPane scroll = new JScrollPane(table);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(form, BorderLayout.NORTH);
        getContentPane().add(scroll, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        btnSalvar.addActionListener(new ActionListener(){
            @Override public void actionPerformed(ActionEvent e) { salvarRecurso(); }
        });

        carregarEspacos();
        carregarTabela();
    }

    private void carregarEspacos() {
        cbEspaco.removeAllItems();
        List<Espaco> lista = BancoMemoria.getInstance().listarEspacos();
        for (Espaco e : lista) cbEspaco.addItem(e);
    }

    private void salvarRecurso() {
        String desc = tfDescricao.getText().trim();
        String tipo = tfTipo.getText().trim();
        String status = tfStatus.getText().trim();
        Espaco esp = (Espaco) cbEspaco.getSelectedItem();

        if (desc.isEmpty()) { JOptionPane.showMessageDialog(this, "Descri\u00E7\u00E3o \u00E9 obrigat\u00F3ria."); return; }
        if (tipo.isEmpty()) { JOptionPane.showMessageDialog(this, "Tipo \u00E9 obrigat\u00F3rio."); return; }
        if (status.isEmpty()) { JOptionPane.showMessageDialog(this, "Status \u00E9 obrigat\u00F3rio."); return; }

        BancoMemoria db = BancoMemoria.getInstance();
        int id = db.listarRecursos().size() + 1;
        RecursoEducacional r = new RecursoEducacional(id, desc, tipo, status);
        if (esp != null) r.associarEspaco(esp);
        db.adicionarRecurso(r);
        limparFormulario();
        carregarTabela();
        JOptionPane.showMessageDialog(this, "Recurso salvo com sucesso.");
    }

    private void limparFormulario() {
        tfDescricao.setText(""); tfTipo.setText(""); tfStatus.setText("");
    }

    private void carregarTabela() {
        tableModel.setRowCount(0);
        List<RecursoEducacional> lista = BancoMemoria.getInstance().listarRecursos();
        for (RecursoEducacional r : lista) {
            tableModel.addRow(new Object[]{r.getId(), r.getDescricao(), r.getTipo(), r.getStatus(), r.getEspaco()!=null? r.getEspaco().getNome():""});
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new RecursoForm().setVisible(true);
        });
    }
}
