package com.drewett;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.drewett.controller.HomeController;

public class AppTest {

	@Test
	public void testApp() {
		HomeController hc = new HomeController();
		String result = hc.home();
		assertEquals(result , "home response");
	}
}
