package com.neotech.lesson02;

import org.testng.annotations.Test;

//HW1: Executing tests using priority and enable attributes
//
//Create a class TaskOne that has 5 test methods named:
//firstMethod
//firstMethod1
//secondMethod
//thirdMethod
//fourthMethod
//
//And each of them printing the method name
//Run and observe results
//
//Then, add the needed attributes to print the following result:
//fourthMethod
//thirdMethod
//secondMethod
//firstMethod
public class Hw1_Lesson2 {
	
	@Test(priority=4)
	public void firstMethod() {
		System.out.println("firstMethod");
	}
	
	@Test(enabled=false)
	public void firstMethod1() {
		System.out.println("firstMethod1");
	}
	
	@Test(priority=3)
	public void secondMethod() {
		System.out.println("secondMethod");
	}
	
	@Test(priority=2)
	public void thirdMethod() {
		System.out.println("thirdMethod");
	}
	
	@Test
	public void fourthMethod() {
		System.out.println("fourthMethod");
	}
	
}
