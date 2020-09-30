package motta;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class MottakerTest {
	
	@Test
	public void testSpraak() {
		Assert.assertEquals(hello("se,en;q=0.5,no"), "Hello ");
		Assert.assertEquals(hello("no,en,de"), "Hallo ");
		Assert.assertEquals(hello("de,no;q=0.8,e;q=0.5"), "Guten tag ");
	}
	
	public static String hello(String spraak) {
		String hello = "Hello ";
		String[] alleSpraak = spraak.split(",");
		if(alleSpraak[0].toLowerCase().contains("no") || alleSpraak[0].toLowerCase().contains("nb")) {
			hello = "Hallo ";
		}
		else if(alleSpraak[0].toLowerCase().contains("de")) {
			hello = "Guten tag ";
		}
		return hello;
	}

}
