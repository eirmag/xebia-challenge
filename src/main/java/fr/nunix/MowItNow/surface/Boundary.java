package fr.nunix.MowItNow.surface;

import org.javatuples.Pair;

public class Boundary {

	public static final Boundary NO_LIMIT = new Boundary(new Pair<Integer, Integer>(Integer.MIN_VALUE, Integer.MIN_VALUE)
			, new Pair<Integer, Integer>(Integer.MAX_VALUE, Integer.MAX_VALUE));

	public Boundary(Pair<Integer, Integer> lowerLimit, Pair<Integer, Integer> upperLimit) {
		this.lowerLimit = lowerLimit;
		this.upperLimit = upperLimit;
	}
	final protected Pair<Integer,Integer> lowerLimit;
	final protected Pair<Integer, Integer> upperLimit;
	
	public boolean widthMove(int i) {
		if (i >= lowerLimit.getValue0() && i <= upperLimit.getValue0())
			return true;
		
		return false;
	}
	
	public boolean heightMove(int i) {
		if (i >= lowerLimit.getValue1() && i <= upperLimit.getValue1())
			return true;
		
		return false;
	}
	
	
}
