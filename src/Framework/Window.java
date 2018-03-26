package Framework;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Framework.Game;

@SuppressWarnings( "serial" )
// Pretty much controls all other classes.
class Window
	extends
	JPanel
{
	// Changing these changes screen size.
	public static final int ScreenWidth = 800;
	public static final int ScreenHeight = 600;
	
	// Gotta protecc your privates.
	private JFrame frame;
	private Game theGame = new Game();
	
	// Use these to access keyboard and mouse.
	public Keyboard kbd = new Keyboard();
	public Mouse mouse = new Mouse();
	// 
	Window()
	{
		// Now listen closely!
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
		
		// Here's the deal!
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
		
		// He'll slip and slide, on this banana peel!
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
	
	// Only gets called sometimes, not too reliable.
	@Override
	protected void paintComponent( Graphics gfx )
	{
		super.paintComponent( gfx );
		
		gfx.setColor( Color.BLACK );
		gfx.fillRect( 0,0,ScreenWidth,ScreenHeight );
	}
	
	// Called after game updates.
	@Override
	public void paint( Graphics gfx )
	{
		gfx.setColor( Color.BLACK );
		gfx.fillRect( 0,0,ScreenWidth,ScreenHeight );
		theGame.ComposeFrame( gfx );
	}
	
	// Returns screen size.
	@Override
	public Dimension getPreferredSize()
	{
		return( new Dimension( ScreenWidth,ScreenHeight ) );
	}
	
	// Create the GUI explicitly on the Swing event thread.
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
	
	// Update and draw.
	public void Progress()
	{
		theGame.UpdateModel( this );
		repaint();
	}
}