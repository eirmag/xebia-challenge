package fr.nunix.MowItNow;

public class Coordinate {

	private int x;
	private int y;
	private Orientation orientation;

	public Coordinate(int x, int y, Orientation o) {
		this.x = x;
		this.y = y;
		this.orientation = o;
	}

	/**
	 * We are in a 2D system, with both positive and negative values.
	 * Boundaries are checked by the lawn
	 * 
	 * @return
	 * @throws NotSupportedOrientation
	 */
	public Coordinate forward()  {
		switch (this.orientation) {
		case EAST:
			x += 1;
			break;
		case NORTH:
			y += 1;
			break;
		case WEST:
			x -= 1;
			break;
		case SOUTH:
			y -= 1;
			break;
		}
		
		return this;

	}

	public Coordinate right() {
		this.orientation = orientation.right();
		return this;

	}

	public Coordinate left() {
		this.orientation = orientation.left();
		return this;
	}

	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public Orientation getOrientation(){
		return this.orientation;
	}
	
	public boolean equals(Coordinate c) {
		if (this.x == c.x && this.y == c.y && this.orientation == c.orientation)
			return true;
		
		return false;
	}
}
