package com.xtolmasters.tests.se.examples.gwt.greetings;

import com.xtolmasters.se.examples.gwt.greetings.shared.FieldVerifier;

import junit.framework.TestCase;

public class FieldVerifierTest extends TestCase {

	public void testNullNotValidName() throws Exception {
		boolean result = FieldVerifier.isValidName(null);
		assertFalse(result);
	}
	
	public void testShortValidName() throws Exception {
		// If length is < 3, then result should be false
		boolean result = FieldVerifier.isValidName("12");
		assertFalse(result);
	}
	
	public void testThreeValidName() throws Exception {
		// If length is == 3 then result should be false
		boolean result = FieldVerifier.isValidName("123");
		assertFalse(result);
	}
	
	public void testLongValidName() throws Exception {
		// If length is > 3 then result should be true
		boolean result = FieldVerifier.isValidName("123456789");
		assertTrue(result);
	}
}
