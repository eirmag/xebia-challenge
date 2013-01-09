package fr.nunix.MowItNow;

public class Mow {
	
	private Coordinate coordinate;
	private Lawn lawn;


	public Mow(Lawn l, Coordinate c) {
		this.coordinate = c;
		this.lawn = l;
	}


	public boolean check(Coordinate c) {
		if (c.equals(coordinate))
			return true;
		return false;
		
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


	public Coordinate getCoordinate() {
		return coordinate;
	}
	


}
