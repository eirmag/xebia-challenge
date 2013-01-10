package fr.nunix.MowItNow;

import java.io.StringReader;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import org.javatuples.Pair;
import org.junit.Test;

import fr.nunix.MowItNow.command.Command;
import fr.nunix.MowItNow.controler.MowControler;
import fr.nunix.MowItNow.imprt.Instruction;
import fr.nunix.MowItNow.imprt.InvalidParsingLine;
import fr.nunix.MowItNow.object.MovableObjectException;
import fr.nunix.MowItNow.object.Mow;
import fr.nunix.MowItNow.surface.Coordinate;

public class MowControlerTest {

	//XXX externalize configuration
	static final String finalTest = new StringBuilder()
    .append("5 5\n")
    .append("1 2 N\n")
    .append("GAGAGAGAA\n")
    .append("3 3 E\n")
    .append("AADAADADDA").toString();
    

     
	@Test
	public void mowControler() throws InvalidParsingLine, MovableObjectException {
		Instruction instruction = new Instruction(new StringReader(finalTest));

		System.out.println("Extracted Lawn : " + instruction.getLawn());
		for (Pair<Mow, List<Command>> pair : instruction.getMows()){

			Mow m = pair.getValue0();
			System.out.println("--- Mow : " + m);
			List<Command> commands = pair.getValue1();
			
			m.addObserver(new Observer() {
				
				@Override
				public void update(Observable o, Object arg) {
					if (arg instanceof Coordinate)
						System.out.println("Final coordinate for mow " + o + " : " + arg);
				
				}
			});
			System.out.println("... execute " + commands.size() + " commands.");
			m.execute(commands);

		}
		
	}

}
