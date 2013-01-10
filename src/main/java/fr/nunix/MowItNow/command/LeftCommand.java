package fr.nunix.MowItNow.command;

import fr.nunix.MowItNow.Mow;

public class LeftCommand extends Command {

	@Override
	public void execute(Mow m) {
		m.left();
	}

}
