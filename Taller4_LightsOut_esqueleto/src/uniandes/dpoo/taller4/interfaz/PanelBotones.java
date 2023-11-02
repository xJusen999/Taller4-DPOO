package uniandes.dpoo.taller4.interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import uniandes.dpoo.taller4.modelo.*;
import uniandes.dpoo.taller4.interfaz.*;

@SuppressWarnings("serial")
public class PanelBotones extends JPanel {

    private Tablero tablero; 
    private Top10 top10;
    private PanelConfiguracion panelConfiguracion;
    private PanelTablero panelTablero;
    

    // BOTONES A USAR NUEVO, REINICIAR, TOP-10, CAMBIAR JUGADOR
    public PanelBotones(Tablero tablero, Top10 top10, PanelConfiguracion panelConfiguracion,PanelTablero panelTablero) {
        this.tablero = tablero; 
        this.top10 = top10;

        setLayout(new GridLayout(4, 1));

        JButton Nuevo = new JButton("NUEVO");
        JButton Reiniciar = new JButton("REINICIAR");
        JButton Top10 = new JButton("TOP-10");
        JButton CambJugador = new JButton("CAMBIAR JUGADOR");

        
        
        
        Nuevo.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                reiniciarTablero();
        	
        	}
        });

        Reiniciar.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                reiniciarTablero();
               
            }
        });
        
        Top10.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                abrirDialogoTop10(); 
            }
        });
        
        
        
        

        add(Nuevo);
        add(Reiniciar);
        add(Top10);
        add(CambJugador);
    }
    
    
    private void abrirDialogoTop10() {
       
        DialogoTop10 dialogo = new DialogoTop10(top10);
    }
   
    
    private void reiniciarTablero() {
        if (tablero != null) {
            tablero.reiniciar();
            panelTablero.actualizarTablero(tablero); 
        }
    }
}