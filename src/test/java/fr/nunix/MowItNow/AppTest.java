package fr.nunix.MowItNow;

import static org.junit.Assert.*;

import org.junit.Test;

public class AppTest {


    final Coordinate finalc1 = new Coordinate (1,3,Orientation.NORTH);
    final Coordinate finalc2 = new Coordinate (5,1,Orientation.EAST);
    
	@Test
	public void xebiaset() {

        Lawn l = new Lawn (5,5);
        
        Coordinate c1 = new Coordinate (1, 2, Orientation.NORTH);
        Coordinate c2 = new Coordinate (3, 3, Orientation.EAST);
        

        Mow m1 = new Mow (l, c1);
        Mow m2 = new Mow (l, c2);
        
        // m1.start("GAGAGAGAA");
        for (int i=0; i<4; ++i){
        	m1.left();
        	m1.forward();
        }
        m1.forward();
        
       
        //m2.start("AADAADADDA");
        for (int i=0; i<2; ++i){
        	m2.forward();
        	m2.forward();
        	m2.right();

        }

    	m2.forward();
    	m2.right();
    	m2.right();
    	m2.forward();
        
        assertTrue(m1.check(finalc1));
        assertTrue(m2.check(finalc2));
	}
	
	@Test
	public void testooo() {

        Lawn l = new Lawn (5,5);
        
        Coordinate c1 = new Coordinate (0, 0, Orientation.NORTH);
        

        Mow m1 = new Mow (l, c1);
        m1.left();
        m1.forward();
        assertEquals(m1.getCoordinate().getX(), 0);
        assertEquals(m1.getCoordinate().getY(), 0);
        assertEquals(m1.getCoordinate().getOrientation(), Orientation.WEST);

        m1.left();
        m1.forward();

        assertEquals(m1.getCoordinate().getX(), 0);
        assertEquals(m1.getCoordinate().getY(), 0);
        assertEquals(m1.getCoordinate().getOrientation(), Orientation.SOUTH);
        
        m1.left();
        m1.forward();

        assertEquals(m1.getCoordinate().getX(), 1);
        assertEquals(m1.getCoordinate().getY(), 0);
        assertEquals(m1.getCoordinate().getOrientation(), Orientation.EAST);
        
        m1.left();
        m1.forward();

        assertEquals(m1.getCoordinate().getX(), 1);
        assertEquals(m1.getCoordinate().getY(), 1);
        assertEquals(m1.getCoordinate().getOrientation(), Orientation.NORTH);
	}
	
	@Test
	public void testooo2() {

        Lawn l = new Lawn (5,5);
        
        Coordinate c2 = new Coordinate (5, 5, Orientation.EAST);
        

        Mow m1 = new Mow (l, c2);
        
        m1.forward();
        assertEquals(m1.getCoordinate().getX(), 5);
        assertEquals(m1.getCoordinate().getY(), 5);
        assertEquals(m1.getCoordinate().getOrientation(), Orientation.EAST);

        m1.left();
        m1.forward();

        assertEquals(m1.getCoordinate().getX(), 5);
        assertEquals(m1.getCoordinate().getY(), 5);
        assertEquals(m1.getCoordinate().getOrientation(), Orientation.NORTH);
        
        m1.left();
        m1.forward();

        assertEquals(m1.getCoordinate().getX(), 4);
        assertEquals(m1.getCoordinate().getY(), 5);
        assertEquals(m1.getCoordinate().getOrientation(), Orientation.WEST);
        
        m1.left();
        m1.forward();

        assertEquals(m1.getCoordinate().getX(), 4);
        assertEquals(m1.getCoordinate().getY(), 4);
        assertEquals(m1.getCoordinate().getOrientation(), Orientation.SOUTH);
	}
	

	@Test
	public void testincorrectlawn() {

        Lawn l = new Lawn (0,5);
        
        Coordinate c2 = new Coordinate (5, 5, Orientation.EAST);
        

        Mow m1 = new Mow (l, c2);
        
        fail("lawn is 0");
	}

}
