package fr.nunix.MowItNow.surface;

import java.util.StringTokenizer;

import fr.nunix.MowItNow.imprt.InvalidParsingLine;
import fr.nunix.MowItNow.spatial.NotSupportedOrientation;
import fr.nunix.MowItNow.spatial.Orientation;

public class Coordinate {

	private int x;
	private int y;
	private Orientation orientation;

	public Coordinate(int x, int y, Orientation o) {
		this.x = x;
		this.y = y;
		this.orientation = o;
		this.boundary = Boundary.NO_LIMIT;
	}
	
	private Boundary boundary;
	
	public void setBoundary (Boundary boundary) throws OutOfBoundaryException{
		if (!(boundary.heightMove(y) && boundary.widthMove(x)))
			throw new OutOfBoundaryException("you are trying to put limit on an object already out of bound");
		
		this.boundary = boundary;
	
	}
	

	/**
	 * We are in a 2D system, with both positive and negative values.
	 * Boundaries are checked by the lawn
	 * @param boundary 
	 * 
	 * @return
	 * @throws NotSupportedOrientation
	 */
	public Coordinate forward()  {
		switch (this.orientation) {
		case EAST:
			if (boundary.widthMove(x+1))
				x += 1;
			break;
		case NORTH:
			if (boundary.heightMove(y+1))
				y += 1;
			
			break;
		case WEST:
			if (boundary.widthMove(x-1))
				x -= 1;
			break;
		case SOUTH:
			if (boundary.heightMove(y-1))
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
	
	@Override 
	public int hashCode() {
		int result = 11;
		
		result = 17 * result + this.x;
		result = 31 * result + this.y;

		result = 13 * result + this.orientation.hashCode();
		
		return result;
	};
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Coordinate){
			Coordinate c = (Coordinate) o;
			if (this.x == c.x && this.y == c.y && this.orientation == c.orientation)
				return true;
		}
		
		return false;
	}

	public static Coordinate parseCoordinate(String mowPos) throws InvalidParsingLine {

		StringTokenizer st = new StringTokenizer(mowPos);

		if (st.countTokens() != 3)
			throw new InvalidParsingLine(
					"The mow position has to have exactly two integers and one char on a line.");

		try {
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			Orientation o = Orientation.parseOrientation(st.nextToken());

			return new Coordinate(x, y, o);
		} catch (NumberFormatException e) {
			throw new InvalidParsingLine(
					"The mow requires exactly two integers and one character to indicate the position.");
		}
	}
	
	@Override
	public String toString() {
		return new StringBuilder()
			.append("(")
			.append(this.x)
			.append(",")
			.append(this.y)
			.append(",")
			.append(this.orientation)
			.append(")").toString();
			
	}
}
