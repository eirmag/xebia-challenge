package fr.nunix.MowItNow.controler;

import java.util.HashMap;
import java.util.Map;
import fr.nunix.MowItNow.surface.Lawn;

public class MowControler {

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

}
