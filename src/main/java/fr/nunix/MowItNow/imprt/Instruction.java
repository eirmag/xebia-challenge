package fr.nunix.MowItNow.imprt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.javatuples.Pair;

import fr.nunix.MowItNow.Coordinate;
import fr.nunix.MowItNow.InvalidParsingLine;
import fr.nunix.MowItNow.Lawn;
import fr.nunix.MowItNow.Mow;
import fr.nunix.MowItNow.command.Command;

/**
 * This class abstracts the interpretation of input files
 * 
 * @author gabriel
 *
 */
public class Instruction {
	
	/**
	 * Instruction is, by convention
	 * 
	 * One line with the lawn dimension e.g, 5 6
	 * A set of two consecutive lines containing definition and configuration for mows:
	 * 		* initial position of the mow e.g, 1 3 N
	 * 		* list of command to turn and forward in the lawn e.g, GADGDGDA.
	 * 
	 * 
	 * @param instructions
	 * @throws InvalidParsingLine 
	 * @throws Exception 
	 */
	public Instruction(Reader reader) throws InvalidParsingLine{
		
		BufferedReader bf = new BufferedReader(reader);
		List<Pair<Mow, List<Command>>> mows = new ArrayList<Pair<Mow,List<Command>>>();
		
		try {
			String lawnDim = bf.readLine();
			lawn = Lawn.parseLawn(lawnDim);
			
			String line;
			while (null != (line = bf.readLine())){
				String mowPos = line;
				String mowInst = bf.readLine();
				
				Mow m = Mow.parseMow(mowPos);
				List<Command> commands = Command.parseCommands(mowInst);
				
				Pair<Mow, List<Command>> mowInstruction = new Pair<Mow, List<Command>>(m, commands);
				mows.add(mowInstruction);
			}
			
			this.mows = mows;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new InvalidParsingLine("Error while reading the lines");
		}
		
	}
	
	public Lawn getLawn() {
		return lawn;
	}
	public List<Pair<Mow, List<Command>>> getMows() {
		return mows;
	}

	final private Lawn lawn;
	final private List<Pair<Mow, List<Command>>> mows;

}
