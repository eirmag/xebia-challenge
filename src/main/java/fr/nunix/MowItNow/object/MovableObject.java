package fr.nunix.MowItNow.object;

import java.util.List;

import fr.nunix.MowItNow.command.Command;
import fr.nunix.MowItNow.surface.Coordinate;
import fr.nunix.MowItNow.surface.Surface;

public interface MovableObject {
	/**
	 * set a surface and position the movable object to the currently register coordinate
	 * @param surface
	 */
	void attach (Surface surface) throws MovableObjectException;

	/**
	 * set a surface and position the movable object at a given initial coordinate
	 * @param surface
	 * @param initial
	 * @throws MowException 
	 */
	void attach (Surface surface, Coordinate initial) throws MovableObjectException;
	
	void moveForward ();
	void turnLeft ();
	void turnRight ();

	/**
	 * Execute a bunch of commands on the movable objects
	 * @param commands
	 */
	void execute(List<Command> commands);
	
	
	
}