package com.plamenti;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import bg.mobile.Pages;

public class HomePageTest {

	@BeforeTest
	public void setUp() {
		Pages.homePage().navigateTo();
	}
	
	@AfterTest
	public void tearDown() {
		Browser.close();
	}
	
	@Test
	public void verifyHomePage() {
		assertTrue(Pages.homePage().isCorrectTitle());
	}
}
