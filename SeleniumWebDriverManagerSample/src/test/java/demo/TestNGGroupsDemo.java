package demo;

import org.testng.annotations.Test;

@Test(groups = {"AllClassTest"})
public class TestNGGroupsDemo {

	@Test(groups = {"sanity"})
	public void test1() {
		System.out.println("inside test1");

	}

	@Test(groups = {"sanity", "smoke"})
	public void test2() {
		System.out.println("inside test2");

	}

	@Test(groups = {"regression"})
	public void test3() {
		System.out.println("inside test3");

	}

	@Test(groups = {"windows.regression"})
	public void test4() {
		System.out.println("inside test4");

	}

	@Test(groups = {"linux.regression"})
	public void test5() {
		System.out.println("inside test5");

	}

}
