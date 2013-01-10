package fr.nunix.MowItNow.command;

import fr.nunix.MowItNow.Mow;

public class RightCommand extends Command {

	@Override
	public void execute(Mow m) {
		m.right();
	}

}
