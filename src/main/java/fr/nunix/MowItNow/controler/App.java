package fr.nunix.MowItNow.controler;

import java.util.Observable;
import java.util.Observer;

/**
 * Hello world!
 *
 */
public class App implements Observer
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
    }

	@Override
	public void update(Observable o, Object arg) {
		if (arg instanceof String)
			System.out.println("App Observer: " + arg);
		
	}
}
