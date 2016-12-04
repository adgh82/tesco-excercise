package org.sape.tesco.perfectnumber;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class NumberCheckerTest {

	@Test
	public void testCheckNumberWith0() {
		assertFalse(NumberChecker.checkNumber(0));
	}
	
	@Test
	public void testCheckNumberWith1() {
		assertFalse(NumberChecker.checkNumber(1));
	}
	
	@Test
	public void testCheckNumberWith6() {
		assertTrue(NumberChecker.checkNumber(6));
	}
	
	

}
