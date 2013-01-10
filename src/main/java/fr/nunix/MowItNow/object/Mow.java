package fr.nunix.MowItNow.object;

import java.util.List;
import java.util.Observable;

import fr.nunix.MowItNow.command.Command;
import fr.nunix.MowItNow.imprt.InvalidParsingLine;
import fr.nunix.MowItNow.surface.Coordinate;
import fr.nunix.MowItNow.surface.Surface;

public class Mow extends Observable implements MovableObject{
	
	private Coordinate coordinate;
	private Surface surface;

	/**
	 * 
	 * @param c
	 * @param s
	 * @throws MovableObjectException A movable object has to be placed on a surface, with definite coordinate. If one of the argument is null, this expcetion is thrown
	 */
	public Mow(Coordinate c, Surface s) throws MovableObjectException {
		init(s,c);
	}

	public void moveForward() {
			this.coordinate.forward();		
	}


	public void turnRight() {
		this.coordinate.right();
	}

	public void turnLeft() {
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
	 * @throws MovableObjectException 
	 */
	public static Mow parseMow(String mowPos, Surface s) throws InvalidParsingLine, MovableObjectException {
		
		Coordinate c = Coordinate.parseCoordinate(mowPos);
		return new Mow(c, s);

	}

	/**
	 * Execute a bunch of commands on the 
	 * @param commands
	 */
	@Override
	public void execute(List<Command> commands) {

		for (Command c: commands)
			c.execute(this);
			
		Coordinate position = getPosition();
		setChanged();
		notifyObservers(position);
		
	}

	@Override
	public void attach(Surface surface) throws MovableObjectException {
		attach(surface, coordinate);
	}

	@Override
	public void attach(Surface surface, Coordinate initial) throws MovableObjectException {
		init (surface, initial);
		this.surface.notify(this);
		
		
	}
	
	private void init (Surface s, Coordinate position) throws MovableObjectException{
		if (null == position)
			throw new MovableObjectException ("Coordinate can't be null");
		if (null == s)
			throw new MovableObjectException ("Surface can't be null");
		
		this.coordinate = position;
		this.coordinate.setBoundary(s.getBoundary());
		this.surface = s;
	}
	
	@Override
	public String toString() {
		return "Mow@" + surface.toString() + " " + coordinate.toString();
	}
	


}
