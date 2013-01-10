package fr.nunix.MowItNow;

import static org.junit.Assert.*;

import java.io.StringReader;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import org.javatuples.Pair;
import org.junit.Test;

import fr.nunix.MowItNow.command.Command;
import fr.nunix.MowItNow.imprt.Instruction;

public class MowControlerTest {

	//XXX externalize configuration
	static final String finalTest = new StringBuilder()
    .append("5 5\n")
    .append("1 2 N\n")
    .append("GAGAGAGAA\n")
    .append("3 3 E\n")
    .append("AADAADADDA").toString();
    

     
	@Test
	public void mowControler() throws InvalidParsingLine {
		Instruction instruction = new Instruction(new StringReader(finalTest));
		
		for (Pair<Mow, List<Command>> pair : instruction.getMows()){
			
			Mow m = pair.getValue0();
			List<Command> commands = pair.getValue1();
			
			MowControler mc = MowControler.getInstance(instruction.getLawn());
			m.addObserver(new Observer() {
				
				@Override
				public void update(Observable o, Object arg) {
					if (arg instanceof Coordinate)
						System.out.println("Final coordinate for mow " + o + " : " + arg);
				
				}
			});
			
			mc.deploy(m);
			m.execute(commands);

		}
		
	}

}
