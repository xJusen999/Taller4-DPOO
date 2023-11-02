package uniandes.dpoo.taller4.interfaz;
import javax.swing.*;
import java.awt.*;
import java.util.Collection;
import uniandes.dpoo.taller4.modelo.Top10;
import uniandes.dpoo.taller4.modelo.RegistroTop10;
import java.io.File;

@SuppressWarnings("serial")
public class DialogoTop10 extends JDialog {

    public DialogoTop10(Top10 top10) {
        File archivoRegistros = new File("./data/top10.csv");
        top10.cargarRecords(archivoRegistros);

        setTitle("Top 10");
        setSize(400, 300);
        setResizable(false);

        JPanel panelRegistros = new JPanel(new GridLayout(1, 1));

        Collection<RegistroTop10> registros = top10.darRegistros();

        JList<RegistroTop10> jList = new JList<>(registros.toArray(new RegistroTop10[0]));
        jList.setCellRenderer(new RegistroTop10Renderer());

        panelRegistros.add(new JScrollPane(jList));

        add(panelRegistros);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    private class RegistroTop10Renderer extends DefaultListCellRenderer {
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

            RegistroTop10 registro = (RegistroTop10) value;
            String text = registro.darNombre() + " - " + registro.darPuntos();
            setText(text);
            setHorizontalAlignment(SwingConstants.CENTER); 

            return this;
        }//fgdrhdsfhgwei
        
    }

    public static void main(String[] args) {
        Top10 top10 = new Top10();
        new DialogoTop10(top10);
    }
}