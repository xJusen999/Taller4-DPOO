package uniandes.dpoo.taller4.interfaz;
import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class PanelInfo extends JPanel {
    private JLabel jugadasLabel;
    private JLabel jugadorLabel;
    private JLabel contadorLabel;
    private JTextField jugadorTextField;
    private int jugadasCount; 

    public PanelInfo() {
        setLayout(new GridLayout(1, 2)); 

        jugadasLabel = new JLabel("Jugadas: ");
        contadorLabel = new JLabel("0");
        jugadorLabel = new JLabel("Jugador: ");
        jugadorTextField = new JTextField();

        
        add(jugadasLabel);
        add(contadorLabel);
        add(jugadorLabel);
        add(jugadorTextField);
    }

    
    public void actualizarContadorJugadas(int jugadas) {
        jugadasCount = jugadas;
        contadorLabel.setText(String.valueOf(jugadasCount));
    }

   
    public String obtenerNombreJugador() {
        return jugadorTextField.getText();
    }
}