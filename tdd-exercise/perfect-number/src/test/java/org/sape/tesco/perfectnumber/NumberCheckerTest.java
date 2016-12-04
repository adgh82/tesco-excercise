package org.sape.tesco.perfectnumber;

import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class NumberCheckerTest {

	@Test
	public void testCheckNumberWith0() {
		assertFalse(NumberChecker.checkNumber(0));
	}

}
