package fr.nunix.MowItNow;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.nunix.MowItNow.object.MovableObject;
import fr.nunix.MowItNow.object.MovableObjectException;
import fr.nunix.MowItNow.object.Mow;
import fr.nunix.MowItNow.spatial.NotSupportedOrientation;
import fr.nunix.MowItNow.spatial.Orientation;
import fr.nunix.MowItNow.surface.IncorrectLawnLimit;
import fr.nunix.MowItNow.surface.InfiniteLawn;
import fr.nunix.MowItNow.surface.Lawn;
import fr.nunix.MowItNow.surface.Coordinate;
import fr.nunix.MowItNow.surface.OutOfBoundaryException;

public class CoordinateTest {
	
	@Test
	public void incrementWithBoundary () throws NotSupportedOrientation, MovableObjectException, IncorrectLawnLimit{
		
		Coordinate c = new Coordinate(0, 0, Orientation.SOUTH);
		MovableObject m = new Mow(c,new Lawn(0,0));
		m.moveForward();
		m.moveForward();
		m.moveForward();
		assertEquals (0, c.getX());
		assertEquals (0, c.getY());
		assertEquals (Orientation.SOUTH, c.getOrientation());
	}
	
	@Test
	public void increment () throws NotSupportedOrientation, MovableObjectException{
		Coordinate c = new Coordinate(0, 0, Orientation.SOUTH);
		MovableObject m = new Mow(c,new InfiniteLawn());
		m.moveForward();
		m.moveForward();
		m.moveForward();
		assertEquals (0, c.getX());
		assertEquals (-3, c.getY());
		assertEquals (Orientation.SOUTH, c.getOrientation());
	}
	
	@Test
	public void roundAbout () throws NotSupportedOrientation, MovableObjectException{
		Coordinate c = new Coordinate(4, 4, Orientation.SOUTH);
		MovableObject m = new Mow(c,new InfiniteLawn());
		m.turnLeft();
		m.moveForward();
		m.turnLeft();
		m.moveForward();
		m.turnLeft();
		m.moveForward();
		m.turnLeft();
		m.moveForward();
		assertEquals (4, c.getX());
		assertEquals (4, c.getY());
		assertEquals (Orientation.SOUTH, c.getOrientation());
	}
	
	@Test
	public void turnAndMove () throws NotSupportedOrientation, MovableObjectException{
		Coordinate c = new Coordinate(1, 3, Orientation.WEST);
		MovableObject m = new Mow(c,new InfiniteLawn());
		m.turnRight();
		m.moveForward();
		assertEquals (1, c.getX());
		assertEquals (4, c.getY());
		assertEquals (Orientation.NORTH, c.getOrientation());
	}
	

	@Test
	public void rotateRight () throws NotSupportedOrientation, MovableObjectException{
		Coordinate c = new Coordinate(0, 0, Orientation.NORTH);

		MovableObject m = new Mow(c,new InfiniteLawn());
		m.turnRight();
		assertEquals (Orientation.EAST, c.getOrientation());
		m.turnRight();
		assertEquals (Orientation.SOUTH, c.getOrientation());
		m.turnRight();
		assertEquals (Orientation.WEST, c.getOrientation());
		m.turnRight();
		assertEquals (Orientation.NORTH, c.getOrientation());
	}
	
	@Test
	public void rotateLeft () throws NotSupportedOrientation, MovableObjectException{
		Coordinate c = new Coordinate(0, 0, Orientation.NORTH);

		MovableObject m = new Mow(c,new InfiniteLawn());
		m.turnLeft();
		assertEquals (Orientation.WEST, c.getOrientation());
		m.turnLeft();
		assertEquals (Orientation.SOUTH, c.getOrientation());
		m.turnLeft();
		assertEquals (Orientation.EAST, c.getOrientation());
		m.turnLeft();
		assertEquals (Orientation.NORTH, c.getOrientation());
	}
	
	@Test(expected=OutOfBoundaryException.class)
	public void outofboundary () throws MovableObjectException, IncorrectLawnLimit{
		Coordinate c = new Coordinate(5, 6, Orientation.NORTH);
		new Mow(c,new Lawn(5,5));
	}


}
