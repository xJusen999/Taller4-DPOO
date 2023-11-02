package uniandes.dpoo.taller4.interfaz;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import uniandes.dpoo.taller4.modelo.Tablero;

@SuppressWarnings("serial")
public class PanelConfiguracion extends JPanel {

    private JComboBox<String> tamano;
    private JRadioButton difFacil;
    private JRadioButton difMedio;
    private JRadioButton difDificil;
    private Tablero tablero;
    private PanelBotones panelBotones;
    private PanelTablero panelTablero;

    public PanelConfiguracion(Tablero tablero,PanelBotones panelBotones, PanelTablero panelTablero) {
        this.tablero = tablero;
        this.panelBotones = panelBotones;
        this.panelTablero = panelTablero;
        
        setBackground(Color.BLUE);
       
        JLabel tamanoLabel = new JLabel("Tamaño: ");
        JPanel tamanoPanel = new JPanel();
        tamanoPanel.add(tamanoLabel);
        tamano = new JComboBox<>(new String[] { "5x5", "6x6", "7x7" });
        tamanoPanel.add(tamano);

        JLabel dificultadLabel = new JLabel("Dificultad: ");
        JPanel dificultadPanel = new JPanel(new GridLayout(1, 3));
        dificultadPanel.add(dificultadLabel);

        difFacil = new JRadioButton("Fácil");
        difMedio = new JRadioButton("Medio");
        difDificil = new JRadioButton("Difícil");

        ButtonGroup dificultadGroup = new ButtonGroup();
        dificultadGroup.add(difFacil);
        dificultadGroup.add(difMedio);
        dificultadGroup.add(difDificil);

        dificultadPanel.add(difFacil);
        dificultadPanel.add(difMedio);
        dificultadPanel.add(difDificil);

        tamano.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedSize = getSelectedTamano();
                int newSize = 5; 

                if (selectedSize.equals("5x5")) {
                    newSize = 5;
                } else if (selectedSize.equals("6x6")) {
                    newSize = 6;
                } else if (selectedSize.equals("7x7")) {
                    newSize = 7;
                }

                 Tablero newTablero = new Tablero(newSize); 
                panelTablero.actualizarTablero(tablero); 
                
                
            }
        });
        difFacil.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (tablero != null) {
                    tablero.desordenar(5); 
                    panelTablero.actualizarTablero(tablero); 
                }
            }
        });

        difMedio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (tablero != null) {
                    tablero.desordenar(10); 
                    panelTablero.actualizarTablero(tablero); 
                }
            }
        });

        difDificil.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (tablero != null) {
                    tablero.desordenar(15); 
                    panelTablero.actualizarTablero(tablero); 
                }
            }
        });//AAAAAAAAAAAAAAAAAA FUNCIONAPSFNSADJG

      
        setLayout(new GridLayout(1, 2));
        add(tamanoPanel);
        add(dificultadPanel);
        
        
    }

    public String getSelectedTamano() {
        return (String) tamano.getSelectedItem();
    }

    public String getSelectedDificultad() {
        if (difFacil.isSelected()) {
            return "Fácil";
        } else if (difMedio.isSelected()) {
            return "Medio";
        } else if (difDificil.isSelected()) {
            return "Difícil";
        }
        return "";
    }
}