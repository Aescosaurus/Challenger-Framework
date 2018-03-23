package Code;

import java.awt.Color;
import java.awt.Graphics;

public class Player
{
	float x = 10.0f;
	float y = 10.0f;
	// 
	public void Update()
	{
		++x;
	}
	
	public void Draw( Graphics gfx )
	{
		gfx.setColor( Color.RED );
		gfx.fillRect( ( int )x,( int )y,50,50 );
	}
}
