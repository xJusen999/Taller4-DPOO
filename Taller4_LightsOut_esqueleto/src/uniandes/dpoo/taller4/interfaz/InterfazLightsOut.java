package uniandes.dpoo.taller4.interfaz;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;


import uniandes.dpoo.taller4.modelo.*;


@SuppressWarnings("serial")
public class InterfazLightsOut extends JFrame {

	
	
	private PanelConfiguracion panelConfiguracion;
	private PanelTablero panelTablero;
	private PanelBotones panelBotones;
	private PanelInfo panelInfo;
	
	private Tablero tablero;
	private Top10 top10;
	
	
	public InterfazLightsOut( ) throws Exception
	{
		
		
		
		setTitle( "LightsOut" );
		setSize( 600, 700 );
		setLocationRelativeTo( null );
		setResizable( false );
		setDefaultCloseOperation( EXIT_ON_CLOSE );


		
		tablero = new Tablero(5);
		panelInfo = new PanelInfo();
		top10 = new Top10();
		
		
		setLayout(new BorderLayout());
		
		

		JPanel arriba = new JPanel( );
		arriba.setLayout( new BorderLayout( ) );
		add( arriba, BorderLayout.NORTH );
		
		
		panelConfiguracion = new PanelConfiguracion( tablero, panelBotones, panelTablero );
		arriba.add( panelConfiguracion, BorderLayout.NORTH );


		JPanel centro = new JPanel( );
		centro.setLayout( new BorderLayout( ) );
		add( centro, BorderLayout.CENTER );
		
		
		panelBotones = new PanelBotones( tablero,top10, panelConfiguracion, panelTablero );
		centro.add( panelBotones, BorderLayout.EAST );
		
		panelTablero = new PanelTablero( tablero );
		centro.add( panelTablero, BorderLayout.CENTER );
		
		JPanel abajo = new JPanel ( );
		abajo.setLayout( new BorderLayout( ) );
		add ( abajo, BorderLayout.SOUTH);
		
		panelInfo = new PanelInfo( );
		abajo.add( panelInfo, BorderLayout.SOUTH );
		
		
		
		
		}
	
	public void actualizarPanelInfo() {
        int jugadas = tablero.darJugadas();
        panelInfo.actualizarContadorJugadas(jugadas);
    }
	
	
	public static void main( String[] pArgs )
	{
		try
		{
			UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName( ) );

			InterfazLightsOut interfaz = new InterfazLightsOut( );
			interfaz.setVisible( true );
			
			
			
		}
		catch( Exception e )
		{
			e.printStackTrace( );
		}
			
	}
	
}
