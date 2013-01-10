package fr.nunix.MowItNow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;

import fr.nunix.MowItNow.command.Command;

public class MowControler extends Observable {

	private static Map<Lawn, MowControler>  instances = new HashMap<Lawn, MowControler>();
	private Lawn lawn;

	public static MowControler getInstance(Lawn lawn){
		if (!instances.containsKey(lawn))
			instances.put(lawn, new MowControler(lawn));
		
		return instances.get(lawn);
	}
	
	private MowControler(Lawn lawn) {
		this.lawn = lawn;
	}

	/**
	 * Run a set of instruction on the attached instance. At the end, observers are notified with the final position of the mow
	 * @param m A mow instance in which to execute the commands
	 * @param commands A list of command to move the mow
	 */
	public void deploy(Mow m) {
		lawn.addMow(m);
		
		
	}

}
