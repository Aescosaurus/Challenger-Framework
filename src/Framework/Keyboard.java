package Framework;

public class Keyboard
{
	static final int nKeys = 128;
	boolean[] keyMap = new boolean[nKeys];
	// 
	public Keyboard()
	{
		for( int i = 0; i < nKeys; ++i )
		{
			keyMap[i] = false;
		}
	}
	
	public boolean KeyIsPressed( int keyCode )
	{
		return keyMap[keyCode];
	}
	
	public boolean KeyIsPressed( char key )
	{
		return keyMap[( int )key];
	}
	
	public void Press( int keyCode )
	{
		keyMap[keyCode] = true;
	}
	
	public void Release( int keyCode )
	{
		keyMap[keyCode] = false;
	}
}
