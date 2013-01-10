package fr.nunix.MowItNow;

import static org.junit.Assert.*;

import org.javatuples.Pair;
import org.junit.Test;

import fr.nunix.MowItNow.spatial.NotSupportedOrientation;
import fr.nunix.MowItNow.spatial.Orientation;
import fr.nunix.MowItNow.surface.Boundary;
import fr.nunix.MowItNow.surface.Coordinate;
import fr.nunix.MowItNow.surface.OutOfBoundaryException;

public class CoordinateTest {
	
	private Boundary boundary;
	
	public CoordinateTest ()
	{
		this.boundary = new Boundary(new Pair<Integer, Integer>(0, 0), new Pair<Integer, Integer>(5, 5));
		
	}
	
	@Test
	public void incrementWithBoundary () throws NotSupportedOrientation{
		Coordinate c = new Coordinate(0, 0, Orientation.SOUTH);
		c.setBoundary(boundary);
		c.forward().forward().forward();
		assertEquals (0, c.getX());
		assertEquals (0, c.getY());
		assertEquals (Orientation.SOUTH, c.getOrientation());
	}
	
	@Test
	public void increment () throws NotSupportedOrientation{
		Coordinate c = new Coordinate(0, 0, Orientation.SOUTH);
		c.forward().forward().forward();
		assertEquals (0, c.getX());
		assertEquals (-3, c.getY());
		assertEquals (Orientation.SOUTH, c.getOrientation());
	}
	
	@Test
	public void roundAbout () throws NotSupportedOrientation{
		Coordinate c = new Coordinate(4, 4, Orientation.SOUTH);
		c.left().forward().left().forward().left().forward().left().forward();
		assertEquals (4, c.getX());
		assertEquals (4, c.getY());
		assertEquals (Orientation.SOUTH, c.getOrientation());
	}
	
	@Test
	public void turnAndMove () throws NotSupportedOrientation{
		Coordinate c = new Coordinate(1, 3, Orientation.WEST);
		c.right().forward();
		assertEquals (1, c.getX());
		assertEquals (4, c.getY());
		assertEquals (Orientation.NORTH, c.getOrientation());
	}
	

	@Test
	public void rotateRight () throws NotSupportedOrientation{
		Coordinate c = new Coordinate(0, 0, Orientation.NORTH);
		c.right();
		assertEquals (Orientation.EAST, c.getOrientation());
		c.right();
		assertEquals (Orientation.SOUTH, c.getOrientation());
		c.right();
		assertEquals (Orientation.WEST, c.getOrientation());
		c.right();
		assertEquals (Orientation.NORTH, c.getOrientation());
	}
	
	@Test
	public void rotateLeft () throws NotSupportedOrientation{
		Coordinate c = new Coordinate(0, 0, Orientation.NORTH);
		c.left();
		assertEquals (Orientation.WEST, c.getOrientation());
		c.left();
		assertEquals (Orientation.SOUTH, c.getOrientation());
		c.left();
		assertEquals (Orientation.EAST, c.getOrientation());
		c.left();
		assertEquals (Orientation.NORTH, c.getOrientation());
	}
	
	@Test(expected=OutOfBoundaryException.class)
	public void outofboundary (){
		Coordinate c = new Coordinate(5, 6, Orientation.NORTH);
		c.setBoundary(boundary);
	}


}
