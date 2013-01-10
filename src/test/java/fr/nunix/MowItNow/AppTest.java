package fr.nunix.MowItNow;

import static org.junit.Assert.*;

import java.util.Observer;

import org.junit.Test;

import fr.nunix.MowItNow.controler.App;
import fr.nunix.MowItNow.object.MovableObjectException;
import fr.nunix.MowItNow.object.Mow;
import fr.nunix.MowItNow.spatial.Orientation;
import fr.nunix.MowItNow.surface.Coordinate;
import fr.nunix.MowItNow.surface.IncorrectLawnLimit;
import fr.nunix.MowItNow.surface.Lawn;
import fr.nunix.MowItNow.surface.OutOfBoundaryException;

public class AppTest {


    final Coordinate finalc1 = new Coordinate (1,3,Orientation.NORTH);
    final Coordinate finalc2 = new Coordinate (5,1,Orientation.EAST);
    
	@Test
	public void xebiaset() throws MovableObjectException, IncorrectLawnLimit {
        
        Coordinate c1 = new Coordinate (1, 2, Orientation.NORTH);
        Coordinate c2 = new Coordinate (3, 3, Orientation.EAST);

        Lawn l = new Lawn (5,5);

        Mow m1 = new Mow (c1, l);
        Mow m2 = new Mow (c2, l);
        
        // m1.start("GAGAGAGAA");
        for (int i=0; i<4; ++i){
        	m1.turnLeft();
        	m1.moveForward();
        }
        m1.moveForward();
        
       
        //m2.start("AADAADADDA");
        for (int i=0; i<2; ++i){
        	m2.moveForward();
        	m2.moveForward();
        	m2.turnRight();

        }

    	m2.moveForward();
    	m2.turnRight();
    	m2.turnRight();
    	m2.moveForward();
        
    	
        assertEquals(m1.getPosition(), finalc1);
        assertEquals(m2.getPosition(), finalc2);
	}
	
	@Test
	public void testooo() throws MovableObjectException, IncorrectLawnLimit {

        Lawn l = new Lawn (5,5);
		//MowControler mc = MowControler.getInstance(l);
		
		
		
        Coordinate c1 = new Coordinate (0, 0, Orientation.NORTH);
        

        Mow m1 = new Mow (c1, l);
        
        final Observer observer = new App();
        m1.addObserver(observer);
        
        m1.turnLeft();
        m1.moveForward();
        assertEquals(m1.getPosition().getX(), 0);
        assertEquals(m1.getPosition().getY(), 0);
        assertEquals(m1.getPosition().getOrientation(), Orientation.WEST);

        m1.turnLeft();
        m1.moveForward();

        assertEquals(m1.getPosition().getX(), 0);
        assertEquals(m1.getPosition().getY(), 0);
        assertEquals(m1.getPosition().getOrientation(), Orientation.SOUTH);
        
        m1.turnLeft();
        m1.moveForward();

        assertEquals(m1.getPosition().getX(), 1);
        assertEquals(m1.getPosition().getY(), 0);
        assertEquals(m1.getPosition().getOrientation(), Orientation.EAST);
        
        m1.turnLeft();
        m1.moveForward();

        assertEquals(m1.getPosition().getX(), 1);
        assertEquals(m1.getPosition().getY(), 1);
        assertEquals(m1.getPosition().getOrientation(), Orientation.NORTH);
	}
	
	@Test
	public void testooo2() throws MovableObjectException, IncorrectLawnLimit {

        Lawn l = new Lawn (5,5);
        
        Coordinate c2 = new Coordinate (5, 5, Orientation.EAST);

        Mow m1 = new Mow (c2, l);
        
        m1.moveForward();
        assertEquals(m1.getPosition().getX(), 5);
        assertEquals(m1.getPosition().getY(), 5);
        assertEquals(m1.getPosition().getOrientation(), Orientation.EAST);

        m1.turnLeft();
        m1.moveForward();

        assertEquals(m1.getPosition().getX(), 5);
        assertEquals(m1.getPosition().getY(), 5);
        assertEquals(m1.getPosition().getOrientation(), Orientation.NORTH);
        
        m1.turnLeft();
        m1.moveForward();

        assertEquals(m1.getPosition().getX(), 4);
        assertEquals(m1.getPosition().getY(), 5);
        assertEquals(m1.getPosition().getOrientation(), Orientation.WEST);
        
        m1.turnLeft();
        m1.moveForward();

        assertEquals(m1.getPosition().getX(), 4);
        assertEquals(m1.getPosition().getY(), 4);
        assertEquals(m1.getPosition().getOrientation(), Orientation.SOUTH);
	}
	

	@Test(expected=OutOfBoundaryException.class)
	public void testincorrectcoordinate() throws MovableObjectException, IncorrectLawnLimit {

        Lawn l = new Lawn (0,5);
        
        Coordinate c2 = new Coordinate (5, 5, Orientation.EAST);
        

        Mow m1 = new Mow (c2, l);
        m1.turnLeft();
        m1.moveForward();
        m1.moveForward();
        
        fail("misplace of the object not detected");
	}
	
	@Test(expected=IncorrectLawnLimit.class)
	public void testincorrectlawn() throws MovableObjectException, IncorrectLawnLimit {

        Lawn l = new Lawn (-1,5);
		
        
        Coordinate c2 = new Coordinate (1, 5, Orientation.EAST);
        

        Mow m1 = new Mow (c2, l);
        m1.turnLeft();
        m1.moveForward();
        m1.moveForward();
        
        fail("lawn is to be detected incorrectly");
	}

}
