package Framework;

// Handles mouse movement and input.
public class Mouse 
{
	private boolean pressed = false;
	private int x = 0;
	private int y = 0;
	// 
	// Checks if left mouse is down.
	public boolean LeftIsPressed()
	{
		return pressed;
	}
	
	// Returns x position of mouse cursor.
	public int GetPosX()
	{
		return x;
	}
	
	// Returns y position of mouse cursor.
	public int GetPosY()
	{
		return y;
	}
	
	// Called by window, you probably shouldn't call this.
	public void Click()
	{
		pressed = true;
	}
	
	// Also called by window, just don't use it.
	public void Release()
	{
		pressed = false;
	}
	
	// Called by window too, won't mess things up too bad but
	//  don't call it just to be safe.
	public void MoveTo( int x,int y )
	{
		this.x = x;
		this.y = y;
	}
}
