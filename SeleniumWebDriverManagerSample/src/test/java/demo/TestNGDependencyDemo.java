package demo;

import org.testng.annotations.Test;

public class TestNGDependencyDemo {

	
	@Test
	//(dependsOnMethods= {"test2","test3"})
	public void test1()
	{
		System.out.println("inside test1");
	}
	
	@Test(dependsOnGroups = {"sanity1"})
	public void test2()
	{
		System.out.println("inside test2");
	}
	
	@Test(groups = {"sanity1"})
	public void test3()
	{
		System.out.println("inside test3");
	}
}
