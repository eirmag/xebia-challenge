package fr.nunix.MowItNow;

import static org.junit.Assert.*;

import org.junit.Test;

public class MowControlerTest {

	//XXX externalize configuration
	static final String finalTest = new StringBuilder()
    .append("5 5\n")
    .append("1 2 N\n")
    .append("GAGAGAGAA\n")
    .append("3 3 E\n")
    .append("AADAADADDA").toString();
    

     
	@Test
	public void mowControler() {
		MowControler mowc = new MowControler(finalTest);
		Object result = mowc.run();
		assertEquals(result, true);
	}

}
