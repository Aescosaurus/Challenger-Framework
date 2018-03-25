package Framework;

import java.awt.Color;
import java.awt.Graphics;

public class Game
{
	// User created variables.
	int x = 50;
	// 
	public Game()
	{
		
	}
	
	public void UpdateModel( Window wnd )
	{
		if( wnd.kbd.KeyIsPressed( 'D' ) )
		{
			++x;
		}
	}
	
	public void ComposeFrame( Graphics gfx )
	{
		gfx.setColor( Color.red );
		gfx.fillRect( x,0,10,10 );
	}
}