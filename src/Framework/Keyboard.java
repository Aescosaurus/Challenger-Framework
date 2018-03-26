package Framework;

// Handles keyboard input.
public class Keyboard
{
	// Increase nKeys if using more than a-z and A-Z.
	static final int nKeys = 128;
	boolean[] keyMap = new boolean[nKeys];
	// 
	// Initializes all elements to false.
	public Keyboard()
	{
		for( int i = 0; i < nKeys; ++i )
		{
			keyMap[i] = false;
		}
	}
	
	// Checks if specified key code is pressed.
	public boolean KeyIsPressed( int keyCode )
	{
		return keyMap[keyCode];
	}
	
	// Checks if char (formatted like 'A' or 'D') is pressed.
	public boolean KeyIsPressed( char key )
	{
		return keyMap[( int )key];
	}
	
	// Called from window, don't call this please.
	public void Press( int keyCode )
	{
		keyMap[keyCode] = true;
	}
	
	// Also called from window, calling this might mess it up.
	public void Release( int keyCode )
	{
		keyMap[keyCode] = false;
	}
}
