package Framework;

import javax.swing.SwingUtilities;

import Framework.Window;

public class Main
{
	static Window wnd = new Window();
	
	public static void main( String[] args ) throws InterruptedException
	{
		SwingUtilities.invokeLater( new Runnable()
		{
			public void run()
			{
				wnd.CreateAndShowGui();
			}
		} );
		
		while( true )
		{
			wnd.Progress();
			Thread.sleep( 10 );
		}
	}
}
