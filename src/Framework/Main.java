package Framework;

import javax.swing.SwingUtilities;

import Framework.Window;

// Initializes everything and contains main method.
public class Main
{
	static Window wnd = new Window();
	
	public static void main( String[] args )
			throws
			InterruptedException
	{
		SwingUtilities.invokeLater( new Runnable()
		{
			public void run()
			{
				wnd.CreateAndShowGui();
			}
		} );
		
		// Game loop.
		while( true )
		{
			wnd.Progress();
			// TODO: Time.deltaTime functionality.
			Thread.sleep( 10 );
		}
	}
}
