package demo;

import org.junit.Ignore;
import org.testng.annotations.Test;

public class TestNGIgnoreDemo {

	
	@Test
	@Ignore
	public void test1()
	{
		System.out.println("inside 1");
	}
	
	@Test
	public void test2()
	{
		System.out.println("inside 2");
	}
}
