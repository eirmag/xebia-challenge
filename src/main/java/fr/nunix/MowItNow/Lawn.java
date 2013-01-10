package fr.nunix.MowItNow;

import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.StringTokenizer;

import fr.nunix.MowItNow.command.Command;

public class Lawn {

	private int width;
	private int height;
	private Set<Mow> mows;

	public Lawn(int width, int height) {
		this.width = width;
		this.height = height;
		this.mows = new HashSet<Mow>();
	}
	
	public void addMow (Mow m){
		this.mows.add(m);
		
	}
	
	public void execute (Mow m, List<Command> commands){
		if (mows.contains(m)){
			for (Command c : commands)
				c.execute(m);
		}
			
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
					"The lawn dimension has to have exactly two integers on a line.");

		try {
			int width = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());

			return new Lawn(width, height);
		} catch (NumberFormatException e) {
			throw new InvalidParsingLine(
					"The lawn requires exactly two integers.");
		}

	}
}
