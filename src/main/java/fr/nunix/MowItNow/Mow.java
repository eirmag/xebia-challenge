package fr.nunix.MowItNow;

import java.util.List;
import java.util.Observable;
import java.util.StringTokenizer;

import fr.nunix.MowItNow.command.Command;

public class Mow extends Observable{
	
	private Coordinate coordinate;

	public Mow(Coordinate c) {
		this.coordinate = c;
	}

	public void forward() {
		this.coordinate.forward();		
	}


	public void right() {
		this.coordinate.right();
	}

	public void left() {
		this.coordinate.left();
	}

	/**
	 * 
	 * @return the position which comprises (x,y,orientation) in the 2D lawn
	 */
	public Coordinate getPosition() {
		return coordinate;
	}

	/**
	 * Create a mow from a string containing x and y positions
	 * 
	 * @param mowPos
	 * @return
	 * @throws InvalidParsingLine
	 */
	public static Mow parseMow(String mowPos) throws InvalidParsingLine {
		
		Coordinate c = Coordinate.parseCoordinate(mowPos);
		return new Mow(c);

	}

	public void execute(List<Command> commands) {

		for (Command c: commands)
			c.execute(this);
			
		Coordinate position = getPosition();
		
		notifyObservers(position);
		
	}
	


}
