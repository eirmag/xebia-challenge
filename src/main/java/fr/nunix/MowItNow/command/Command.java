package fr.nunix.MowItNow.command;

import java.util.ArrayList;
import java.util.List;

import fr.nunix.MowItNow.controler.LetterConvention;
import fr.nunix.MowItNow.imprt.InvalidParsingLine;
import fr.nunix.MowItNow.object.MovableObject;

public abstract class Command {
	public abstract void execute(MovableObject m);

	public static List<Command> parseCommands(String commands) throws InvalidParsingLine {
		
		List<Command> list = new ArrayList<Command>();
		
		for (int i=0; i<commands.length(); ++i){
			Character c = commands.charAt(i);
			if (c.equals(LetterConvention.FORWARD))
				list.add(new ForwardCommand());
			else if (c.equals(LetterConvention.LEFT))
				list.add(new LeftCommand());
			else if (c.equals(LetterConvention.RIGHT))
				list.add(new RightCommand());
			else throw new InvalidParsingLine("Instruction not recognized to move the mow");
		}
		
		return list;
		
	}

}
