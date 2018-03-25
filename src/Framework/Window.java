package Framework;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Framework.Game;

@SuppressWarnings( "serial" )
class Window
	extends
	JPanel
{
	public static final int ScreenWidth = 800;
	public static final int ScreenHeight = 600;
	
	private JFrame frame;
	
	private Game theGame = new Game();
	public Keyboard kbd = new Keyboard();
	public Mouse mouse = new Mouse();
	// 
	Window()
	{
		addKeyListener( new KeyListener()
		{
			@Override
			public void keyTyped( KeyEvent e )
			{
				// TODO: Implement something here @Aesc#9487. ;)
			}
			
			@Override
			public void keyReleased( KeyEvent e )
			{
				kbd.Release( e.getKeyCode() );
			}
			
			@Override
			public void keyPressed( KeyEvent e )
			{
				kbd.Press( e.getKeyCode() );
			}
		} );
		
		addMouseListener( new MouseAdapter()
		{
			@Override
			public void mousePressed( MouseEvent e )
			{
				mouse.Click();
			}
			
			@Override
			public void mouseReleased( MouseEvent e )
			{
				mouse.Release();
			}
		} );
		
		addMouseMotionListener( new MouseAdapter()
		{
			@Override
			public void mouseMoved( MouseEvent e )
			{
				mouse.MoveTo( e.getX(),e.getY() );
			}
		} );
		
		setFocusable( true );
	}
	
	@Override
	protected void paintComponent( Graphics gfx )
	{
		super.paintComponent( gfx );
		
		gfx.setColor( Color.BLACK );
		gfx.fillRect( 0,0,ScreenWidth,ScreenHeight );
	}
	
	@Override
	public void paint( Graphics gfx )
	{
		gfx.setColor( Color.BLACK );
		gfx.fillRect( 0,0,ScreenWidth,ScreenHeight );
		theGame.ComposeFrame( gfx );
	}
	
	@Override
	public Dimension getPreferredSize()
	{
		return( new Dimension( ScreenWidth,ScreenHeight ) );
	}
	
	// create the GUI explicitly on the Swing event thread
	public void CreateAndShowGui()
	{
		// Window mainPanel = new Window();
		
		frame = new JFrame( "Challenger Framework" );
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.getContentPane().add( this );
		frame.pack();
		frame.setLocationByPlatform( true );
		frame.setVisible( true );
	}
	
	public void Progress()
	{
		theGame.UpdateModel( this );
		repaint();
	}
}