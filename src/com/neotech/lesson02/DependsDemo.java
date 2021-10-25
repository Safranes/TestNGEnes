package com.neotech.lesson02;

import org.testng.annotations.Test;

public class DependsDemo {
	@Test
	public void firstTest() {
		System.out.println("firstTest Method");
	}

	@Test
	public void secondTest() {
		System.out.println("secondTest Method");
	}

	@Test
	public void thirdTest() {
		System.out.println("thirdTest Method");
	}

	@Test
	public void fourthTest() {
		System.out.println("fourthTest Method");
	}
}
