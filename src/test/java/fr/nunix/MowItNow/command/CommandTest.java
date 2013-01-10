package fr.nunix.MowItNow.command;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import fr.nunix.MowItNow.InvalidParsingLine;

public class CommandTest {

	@Test
	public void testCommand() throws InvalidParsingLine{
		String commands = "AAAAA";
		List<Command> c = Command.parseCommands(commands);
		assertEquals(commands.length(), c.size());
	}
	

	@Test
	public void testCommand2() throws InvalidParsingLine{
		String commands = "DGAADGAADGAADGAAADAD";
		List<Command> c = Command.parseCommands(commands);
		assertEquals(commands.length(), c.size());
	}
	
	@Test(expected= InvalidParsingLine.class) 
	public void testWrongCommand() throws InvalidParsingLine{
		String commands = "XEBIA";
		List<Command> c = Command.parseCommands(commands);
		fail("Wrong command not detected");
	}
	
	@Test(expected= InvalidParsingLine.class) 
	public void testWrongCommand2() throws InvalidParsingLine{
		String commands = "111";
		List<Command> c = Command.parseCommands(commands);
		fail("Wrong command not detected");
	}
}
