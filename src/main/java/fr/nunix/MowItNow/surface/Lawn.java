package fr.nunix.MowItNow.surface;

import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

import org.javatuples.Pair;

import fr.nunix.MowItNow.imprt.InvalidParsingLine;
import fr.nunix.MowItNow.object.MovableObject;

public class Lawn implements Surface{

	private Set<MovableObject> movableObjects;
	private final Boundary boundary;

	public Lawn(int width, int height) throws IncorrectLawnLimit {
		if (0 > width || 0 > height)
			throw new IncorrectLawnLimit();
		
		this.movableObjects = new HashSet<MovableObject>();
		this.boundary = new Boundary (new Pair<Integer, Integer> (0,0), new Pair<Integer, Integer> (width,height));
	}

	/**
	 * Create a lawn from a string containing width and height dimensions
	 * 
	 * @param lawnDim
	 * @return
	 * @throws InvalidParsingLine
	 */
	public static Lawn parseLawn(String lawnDim) throws InvalidParsingLine {
		StringTokenizer st = new StringTokenizer(lawnDim);

		if (st.countTokens() != 2)
			throw new InvalidParsingLine(
					"The lawn dimension has to have exactly two positive integers on a line.");

		try {
			int width = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());

			return new Lawn(width, height);
		} catch (Exception e) {
			throw new InvalidParsingLine(
					"The lawn requires exactly two positive integers.");
		}

	}


	@Override
	public void notify(MovableObject object) {
		this.movableObjects.add(object);
		
	}

	@Override
	public Boundary getBoundary() {
		return this.boundary;
	}
	
	@Override
	public String toString() {
		return "(" + this.boundary.upperLimit.getValue0() 
				+ "," + this.boundary.upperLimit.getValue1() + ")";
	}
}
