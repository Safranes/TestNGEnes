package com.neotech.lesson04;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ListenerDemo {

	@Test
	public void test1() {
		System.out.println("This is test 1");
		//makin sure this method passes
		Assert.assertTrue(true);
	}
	
	@Test
	public void test2() {
		System.out.println("This is test 2");
		//making sure this method fails
		Assert.assertTrue(false);
	}
}
