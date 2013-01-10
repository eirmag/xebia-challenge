package fr.nunix.MowItNow.command;

import fr.nunix.MowItNow.Mow;

public class ForwardCommand extends Command {

	@Override
	public void execute(Mow m) {
		m.forward();
	}

}
