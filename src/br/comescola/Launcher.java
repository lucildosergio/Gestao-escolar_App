package br.comescola;

import javax.swing.SwingUtilities;
import br.comescola.ui.EspacoForm;

public class Launcher {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new EspacoForm().setVisible(true));
    }
}
