package Framework;

public class Mouse 
{
	private boolean pressed = false;
	private int x = 0;
	private int y = 0;
	// 
	public boolean LeftIsPressed()
	{
		return pressed;
	}
	
	public int GetPosX()
	{
		return x;
	}
	
	public int GetPosY()
	{
		return y;
	}
	
	public void Click()
	{
		pressed = true;
	}
	
	public void Release()
	{
		pressed = false;
	}
	
	public void MoveTo( int x,int y )
	{
		this.x = x;
		this.y = y;
	}
}
