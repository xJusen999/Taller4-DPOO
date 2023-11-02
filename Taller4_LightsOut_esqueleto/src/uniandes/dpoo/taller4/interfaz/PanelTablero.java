package uniandes.dpoo.taller4.interfaz;


import uniandes.dpoo.taller4.modelo.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class PanelTablero extends JPanel {
    private Tablero tablero;
    private ImageIcon luzEncendida;
    private ImageIcon luzApagada;
	private boolean[][] casillas;

    public PanelTablero(Tablero tablero) {
        this.tablero = tablero;
        this.luzEncendida = new ImageIcon("data/luz.png"); //instancia para la imagen que debe ser pintada
        this.luzApagada = new ImageIcon("data/luz.png"); //instancia para la imagen normal

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                int tam = tablero.darTablero().length;
                int anchoCasilla = getWidth() / tam;
                int altoCasilla = getHeight() / tam;

                int fila = y / altoCasilla;
                int columna = x / anchoCasilla;

                tablero.jugar(fila, columna);

                repaint();
            }
        });
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        boolean[][] casillas = tablero.darTablero();
        int tam = casillas.length;
        int anchoCasilla = getWidth() / tam;
        int altoCasilla = getHeight() / tam;

        for (int i = 0; i < tam; i++) {
            for (int j = 0; j < tam; j++) {
                if (casillas[i][j]) {
                    g.setColor(Color.YELLOW);
                    g.fillRect(j * anchoCasilla, i * altoCasilla, anchoCasilla, altoCasilla);
                    
                    int x = j * anchoCasilla + (anchoCasilla - luzEncendida.getIconWidth()) / 2;
                    int y = i * altoCasilla + (altoCasilla - luzEncendida.getIconHeight()) / 2;
                    luzEncendida.paintIcon(this, g, x, y);
                } else {
                    
                    int x = j * anchoCasilla + (anchoCasilla - luzApagada.getIconWidth()) / 2;
                    int y = i * altoCasilla + (altoCasilla - luzApagada.getIconHeight()) / 2;
                    luzApagada.paintIcon(this, g, x, y);
                }
            }
        }

        g.setColor(Color.BLACK); //darle bordes a cada casilla.
        for (int i = 0; i < tam; i++) {
            for (int j = 0; j < tam; j++) {
                g.drawRect(j * anchoCasilla, i * altoCasilla, anchoCasilla, altoCasilla);
            }
        }
        
    }
    
    
    public void actualizarTablero(Tablero nuevoTablero) {
        tablero = nuevoTablero;
        repaint(); 
    } 
    
    
}