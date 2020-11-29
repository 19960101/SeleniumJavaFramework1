package listeners;

import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(listeners.TestNGlistener.class)
public class TestNGListenerDemo2 {

	@Test
	public void test4() {
		System.out.println("Inside test4");
	}

	@Test
	public void test5() {
		System.out.println("Inside test5");
	}

	@Test
	public void test6() {
		System.out.println("Inside test3");
		throw new SkipException("this test is skipped");

	}
}
